package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
//@formatter:off
public class IncorrectMovesPawnGameTest {
  // Test de todos los posibles errores al mover
  /*
   * Error!!! No te entiendo: <d><d>{,<d><d>}[0-2] Error!!! No es una coordenada del tablero
   * Error!!! No hay ficha que mover Error!!! No es una de tus fichas Error!!! No vas en diagonal
   * Error!!! No está vacío el destino Error!!! No comes contrarias Error!!! No se puede comer
   * tantas en un movimiento Error!!! No avanzas Error!!! No respetas la distancia Error!!! No se
   * puede comer tantas en un salto
   */

  private void assertErrorMove(Error error, Game originalGame, Coordinate... coordinates) {
    assertEquals(error, this.gameBuilder.build().move(coordinates));
    assertEquals(originalGame, this.gameBuilder.build());
  }

  GameBuilder gameBuilder;

  @Before
  public void prepareGameBuilder() {
    this.gameBuilder = new GameBuilder();
  }

  @Test
  public void testGivenGameWhenMoveWHITEThenEMPTY_ORIGIN() {
    Game game = this.gameBuilder.rows(
        "        ",
        "        ",
        "        ",
        "        ",
        "        ",
        "        ",
        "        ",
        "        ").color(Color.WHITE).build();
    assertErrorMove(Error.EMPTY_ORIGIN,game,
        new Coordinate(4, 3),
        new Coordinate(3, 4));
  }

  @Test
  public void testGivenGameWhenMoveWHITEThenOPPOSITE_PIECE() {
    Game game = this.gameBuilder.rows(
        "        ",
        "        ",
        " n      ",
        "        ",
        "        ",
        "        ",
        "        ",
        "        ").color(Color.WHITE).build();
    assertErrorMove(Error.OPPOSITE_PIECE,game,
        new Coordinate(2, 1),
        new Coordinate(3, 0));
  }

  @Test
  public void testGivenGameWhenMoveDownThenNOT_DIAGONAL() {
    Game game = this.gameBuilder.rows(
        "        ",
        "        ",
        "        ",
        "        ",
        "        ",
        "  b     ",
        "        ",
        "        ").color(Color.WHITE).build();
    assertErrorMove(Error.NOT_DIAGONAL,game,
        new Coordinate(5, 2),
        new Coordinate(4, 2));
  }

  @Test
  public void testGivenGameWhenMoveUpThenNOT_DIAGONAL() {
    Game game = this.gameBuilder.rows(
        "        ",
        "        ",
        "        ",
        "        ",
        "        ",
        "  b     ",
        "        ",
        "        ").color(Color.WHITE).build();
    assertErrorMove(Error.NOT_DIAGONAL,game,
        new Coordinate(5, 2),
        new Coordinate(6, 2));
  }

  @Test
  public void testGivenGameWhenMoveWHITEThenNOT_EMPTY_TARGET() {
    Game game = this.gameBuilder.rows(
        "        ",
        "        ",
        "        ",
        "      n ",
        "       b",
        "        ",
        "        ",
        "        ").color(Color.WHITE).build();
    assertErrorMove(Error.NOT_EMPTY_TARGET,game,
        new Coordinate(4, 7),
        new Coordinate(3, 6));
  }

  @Test
  public void testGivenGameWhenMoveWHITEEatingThenNOT_EMPTY_TARGET() {
    Game game = this.gameBuilder.rows(
        "        ",
        "        ",
        "   n    ",
        "  n     ",
        " b      ",
        "        ",
        "        ",
        "        ").color(Color.WHITE).build();
    assertErrorMove(Error.NOT_EMPTY_TARGET,game,
        new Coordinate(4, 1),
        new Coordinate(2, 3));
  }


  @Test
  public void testGivenGameWhenMoveWHITEThenNOT_ADVANCED() {
    Game game = this.gameBuilder.rows(
        "        ",
        "        ",
        "        ",
        "        ",
        "       b",
        "        ",
        "        ",
        "        ").color(Color.WHITE).build();
    assertErrorMove(Error.NOT_ADVANCED,game,
        new Coordinate(4, 7),
        new Coordinate(5, 6));
  }


  @Test
  public void testGivenGameWhenMoveWHITEThenWITHOUT_EATING() {
    Game game = this.gameBuilder.rows(
        "        ",
        "        ",
        "        ",
        "        ",
        "        ",
        "    b   ",
        "        ",
        "        ").color(Color.WHITE).build();
    assertErrorMove(Error.WITHOUT_EATING,game,
        new Coordinate(5, 4),
        new Coordinate(3, 2));
  }


  @Test
  public void testGivenGameWhenMoveWHITEThenTOO_MUCH_ADVANCED() {
    Game game = this.gameBuilder.rows(
        "        ",
        "        ",
        "        ",
        "        ",
        "        ",
        "b       ",
        "        ",
        "        ").build();
    assertErrorMove(Error.TOO_MUCH_ADVANCED,game,
        new Coordinate(5, 0),
        new Coordinate(2, 3));
  }


  @Test
  public void testGivenGameWhenMoveWHITEThenTOO_MUCH_JUMPS() {
    Game game = this.gameBuilder.rows(
        "        ",
        "        ",
        "        ",
        "        ",
        " b      ",
        "        ",
        "        ",
        "        ").build();
    assertErrorMove(Error.TOO_MUCH_JUMPS,game,
        new Coordinate(4, 1),
        new Coordinate(3, 2),
        new Coordinate(2, 3));
  }

  @Test
  public void testGivenGameWhenMoveWHITEEatingThenTOO_MUCH_JUMPS() {
    Game game = this.gameBuilder.rows(
        "        ",
        "        ",
        "        ",
        "  n     ",
        " b      ",
        "        ",
        "        ",
        "        ").build();
    assertErrorMove(Error.TOO_MUCH_JUMPS,game,
        new Coordinate(4, 1),
        new Coordinate(2, 3),
        new Coordinate(1, 2));
  }
  
  

}
