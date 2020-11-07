package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

  //@formatter:off
  private GameBuilder gameBuilder;

  @Before
  public void prepareGameBuilder() {
    this.gameBuilder = new GameBuilder();
  }

  @Test
  public void testGameBoard() {
    Game game = this.gameBuilder.rows("        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ").build();
    assertEquals(game, new Game(new Board()));
  }

  @Test
  public void testGame() {
    Game game = this.gameBuilder.rows(" n n n n",
                                      "n n n n ",
                                      " n n n n",
                                      "        ",
                                      "        ",
                                      "b b b b ",
                                      " b b b b",
                                      "b b b b ").build();
    assertEquals(game, new Game());
  }

  @Test
  public void testGivenBoardWhenResetThenIsReseted() {
    Game game = this.gameBuilder.rows("        ",
                                      "        ",
                                      " n      ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ").build();
    game.reset();
    assertEquals(game, new Game());
    
  }

  @Test
  public void testGivenGameWhenMoveThenPieceIsMoved() {
    fail("Not yet implemented");
  }
  
  // Test de todos los posibles errores al mover

  @Test
  public void testGivenGameWhenMoveThenIsBlocked() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testGivenGameWhenMoveThenIsNotBlocked() {
    fail("Not yet implemented");
  }
  

  @Test
  public void testGivenGameWhenGameCancelThen() {
    fail("Not yet implemented");
  }

  @Test
  public void testGivenCoordinateWhenGetColorThenWhite() {
    fail("Not yet implemented");
  }

  @Test
  public void testGivenCoordinateWhenGetColorThenBlack() {
    fail("Not yet implemented");
  }
  
  
  @Test
  public void testGivenGameWhenMoveWhiteThenIsBlackTurn() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testGivenGameWhenMoveBlackThenIsWhiteTurn() {
    fail("Not yet implemented");
  }

  @Test
  public void testGivenGameWhenGetPieceThenIsWhite() {
    fail("Not yet implemented");
  }

  @Test
  public void testGivenGameWhenGetPieceThenIsBlack() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testGivenGameWhenGetPieceThenIsEmpty() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testGivenGameWhenGetDimentionThenIsEigth() {
    fail("Not yet implemented");
  }

}
