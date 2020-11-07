package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class IncorrectMovesPawnGameTest {
  // Test de todos los posibles errores al mover
  /*
   * Error!!! No te entiendo: <d><d>{,<d><d>}[0-2] Error!!! No es una coordenada del tablero
   * Error!!! No hay ficha que mover Error!!! No es una de tus fichas Error!!! No vas en diagonal
   * Error!!! No está vacío el destino Error!!! No comes contrarias Error!!! No se puede comer
   * tantas en un movimiento Error!!! No avanzas Error!!! No respetas la distancia Error!!! No se
   * puede comer tantas en un salto
   */

  GameBuilder gameBuilder;

  @Before
  public void prepareGameBuilder() {
    this.gameBuilder = new GameBuilder();
  }

  // @formatter:off
  @Test
  public void testGivenBoardWhenMoveEmptySquareThenEmptySquareError() {
    Game game = this.gameBuilder.rows("        ",
                                      "        ",
                                      " n      ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ").build();
    Coordinate origin = new Coordinate(7, 0);
    Coordinate target = new Coordinate(6, 1);

    Error error =  game.move(origin, target);
    
    assertEquals(Error.EMPTY_ORIGIN, error);
    
  }
  
  
  //@formatter:off

}
