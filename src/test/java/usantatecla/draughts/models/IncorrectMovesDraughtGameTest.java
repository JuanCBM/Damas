package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

//@formatter:off
public class IncorrectMovesDraughtGameTest {

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
  public void testGivenGameWhenMoveThenOPPOSITE_PIECE() {
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      " N      ",
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
                                      "  B     ",
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
                                      "  B     ",
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
                                      "      N ",
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
                                      " B      ",
                                      "        ",
                                      "        ",
                                      "        ")
                                .build();

    assertErrorMove(Error.NOT_EMPTY_TARGET,
                    game, 
                    new Coordinate(4, 1), new Coordinate(2, 3));
    
  }

  @Test
  public void testGivenGameWhenMoveEatingThenCOLLEAGUE_EATING() {    
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "     b  ",
                                      "      B ",
                                      "        ",
                                      "        ")
                                .build();

    assertErrorMove(Error.COLLEAGUE_EATING, 
                    game, 
                    new Coordinate(5, 6), new Coordinate(0, 1));
    
  }

  @Test
  public void testGivenGameWhenMoveEatingThenTOO_MUCH_EATINGS() {    
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "   n    ",
                                      "        ",
                                      "     n  ",
                                      "      B ",
                                      "        ",
                                      "        ")
                                .build();
    
    assertErrorMove(Error.TOO_MUCH_EATINGS, 
                    game, 
                    new Coordinate(5, 6), new Coordinate(0, 1));
    
  }

  @Test
  public void testGivenGameWhenMoveThenTOO_MUCH_JUMPS() {    
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      " B      ",
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
                                      " B      ",
                                      "        ",
                                      "        ",
                                      "        ")
                                .build();
    
    assertErrorMove(Error.TOO_MUCH_JUMPS, 
                    game,
                    new Coordinate(4, 1), new Coordinate(2, 3), new Coordinate(1, 2));
    
  }

}
