package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


//@formatter:off
public class IncorrectMovesPawnGameTest {

  GameBuilder gameBuilder;

  @Before
  public void prepareGameBuilder() {
    this.gameBuilder = new GameBuilder();
  }

  private void assertErrorMove(Error error, Game originalGame, Coordinate... coordinates) {
    assertEquals(error, this.gameBuilder.build().move(coordinates));
    assertEquals(originalGame, this.gameBuilder.build());
  }

  @Test
  public void testGivenGameWhenMoveThenEMPTY_ORIGIN() {
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ")
                                .build();
    
    assertErrorMove(Error.EMPTY_ORIGIN,
                    game, 
                    new Coordinate(4, 3), new Coordinate(3, 4));
  }

  @Test
  public void testGivenGameWhenMoveThenOPPOSITE_PIECE() {
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      " n      ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ")
                                .build();
    
    assertErrorMove(Error.OPPOSITE_PIECE,
                    game, 
                    new Coordinate(2, 1), new Coordinate(3, 0));
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
                                      "        ")
                                .build();
    
    assertErrorMove(Error.NOT_DIAGONAL,
                    game,
                    new Coordinate(5, 2), new Coordinate(4, 2));
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
                                      "        ")
                                .build();
    
    assertErrorMove(Error.NOT_DIAGONAL, 
                    game,
                    new Coordinate(5, 2), new Coordinate(6, 2));
  }

  @Test
  public void testGivenGameWhenMoveThenNOT_EMPTY_TARGET() {
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "        ",
                                      "      n ",
                                      "       b",
                                      "        ",
                                      "        ",
                                      "        ")
                                .build();
    
    assertErrorMove(Error.NOT_EMPTY_TARGET,
                    game, 
                    new Coordinate(4, 7), new Coordinate(3, 6));
  }

  @Test
  public void testGivenGameWhenMoveEatingThenNOT_EMPTY_TARGET() {
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "   n    ",
                                      "  n     ",
                                      " b      ",
                                      "        ",
                                      "        ",
                                      "        ")
                                .build();
    
    assertErrorMove(Error.NOT_EMPTY_TARGET, 
                    game,
                    new Coordinate(4, 1), new Coordinate(2, 3));
  }

  @Test
  public void testGivenGameWhenMoveThenNOT_ADVANCED() {
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "       b",
                                      "        ",
                                      "        ",
                                      "        ")
                                .build();
    
      assertErrorMove(Error.NOT_ADVANCED,
                      game,
                      new Coordinate(4, 7), new Coordinate(5, 6));
  }

  @Test
  public void testGivenGameWhenMoveThenWITHOUT_EATING() {
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "    b   ",
                                      "        ",
                                      "        ")
                                  .build();
    
    assertErrorMove(Error.WITHOUT_EATING, 
                    game,
                    new Coordinate(5, 4), new Coordinate(3, 2));
  }

  @Test
  public void testGivenGameWhenMoveThenTOO_MUCH_ADVANCED() {
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "b       ",
                                      "        ",
                                      "        ")
                                .build();
    
    assertErrorMove(Error.TOO_MUCH_ADVANCED,
                    game,
                    new Coordinate(5, 0), new Coordinate(2, 3));
  }

  @Test
  public void testGivenGameWhenMoveThenTOO_MUCH_JUMPS() {
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      " b      ",
                                      "        ",
                                      "        ",
                                      "        ")
                                .build();
    
    assertErrorMove(Error.TOO_MUCH_JUMPS,
                    game,
                    new Coordinate(4, 1), new Coordinate(3, 2), new Coordinate(2, 3));
  }

  @Test
  public void testGivenGameWhenMoveEatingThenTOO_MUCH_JUMPS() {
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "        ",
                                      "  n     ",
                                      " b      ",
                                      "        ",
                                      "        ",
                                      "        ")
                                .build();
    
    assertErrorMove(Error.TOO_MUCH_JUMPS,
                    game,
                    new Coordinate(4, 1), new Coordinate(2, 3), new Coordinate(1, 2));
  }

}
