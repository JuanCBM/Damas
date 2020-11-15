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
  public void testGivenGameWhenMoveThenEmptyOrigin() {
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
  public void testGivenGameWhenMoveThenOppositePiece() {
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
  public void testGivenGameWhenMoveDownThenNotDiagonal() {
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
  public void testGivenGameWhenMoveUpThenNotDiagonal() {
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
  public void testGivenGameWhenMoveThenNotEmptyTarget() {
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
  public void testGivenGameWhenMoveEatingThenNotEmptyTarget() {
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
  public void testGivenGameWhenMoveThenNotAdvanced() {
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
  public void testGivenGameWhenMoveThenWithoutEating() {
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
  public void testGivenGameWhenMoveThenTooMuchAdvanced() {
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
  public void testGivenGameWhenMoveThenTooMuchJumps() {
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
  public void testGivenGameWhenMoveEatingThenTooMuchJumps() {
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

  @Test
  public void testGivenGameWhenMoveSecondThenColleagueEating(){
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "  n     ",
                                      "   n    ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ")
                                .build();
    assertErrorMove(Error.COLLEAGUE_EATING,game,
        new Coordinate(1, 2),
        new Coordinate(3, 4));
  }

  @Test
  public void testGivenGameWhenMoveSecondThenNotEmptyTarget(){
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "  n     ",
                                      "   b    ",
                                      "        ",
                                      "   b    ",
                                      "  b     ",
                                      "        ",
                                      "        ")
                                .build();
    assertErrorMove(Error.NOT_EMPTY_TARGET,game,
        new Coordinate(1, 2),
        new Coordinate(3, 4),
        new Coordinate(5, 2));
  }
  @Test
  public void testGivenGameWhenMoveSecondDownThenNotDiagonal(){
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "        ",
                                      "    n   ",
                                      "   b    ",
                                      "        ",
                                      "        ",
                                      "        ")
                                .build();
    assertErrorMove(Error.NOT_DIAGONAL,game,
        new Coordinate(3, 4),
        new Coordinate(5, 2),
        new Coordinate(4, 2));
  }

  @Test
  public void testGivenGameWhenMoveSecondRightThenNotDiagonal(){
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "        ",
                                      "    n   ",
                                      "   b    ",
                                      "        ",
                                      "        ",
                                      "        ")
                                .build();
    assertErrorMove(Error.NOT_DIAGONAL,game,
        new Coordinate(3, 4),
        new Coordinate(5, 2),
        new Coordinate(5, 3));
  }

  @Test
  public void testGivenGameWhenMoveSecondLeftThenNotDiagonal(){
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "        ",
                                      "    n   ",
                                      "   b    ",
                                      "        ",
                                      "        ",
                                      "        ")
                                .build();
    assertErrorMove(Error.NOT_DIAGONAL,game,
        new Coordinate(4, 3),
        new Coordinate(2, 5),
        new Coordinate(1, 5));
  }
  @Test
  public void testGivenGameWhenMoveSecondUpThenNotDiagonal(){
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "   n    ",
                                      "  b     ",
                                      "        ",
                                      "        ")
                                .build();
    assertErrorMove(Error.NOT_DIAGONAL,game,
        new Coordinate(5, 2),
        new Coordinate(3, 4),
        new Coordinate(2, 4));
  }

}
