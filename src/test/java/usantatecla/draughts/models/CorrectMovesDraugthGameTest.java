package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class CorrectMovesDraugthGameTest {

  GameBuilder gameBuilder;

  @Before
  public void prepareGameBuilder() {
    this.gameBuilder = new GameBuilder();
  }

  @Test
  public void testGivenGameWhenMoveOneSquareThenDraughtIsMoved() {
    // @formatter:off
    Game game = this.gameBuilder.rows(
                                      " n      ", 
                                      "        ", 
                                      "        ", 
                                      "        ", 
                                      "        ",
                                      "        ", 
                                      "        ", 
                                      "B       ")
                                  .build();
    // @formatter:on
    Coordinate origin = new Coordinate(7, 0);
    Coordinate target = new Coordinate(6, 1);

    game.move(origin, target);

    assertNull(game.getPiece(origin));
    assertNotNull(game.getPiece(target));

  }

  @Test
  public void testGivenGameWhenMoveMultiSquareThenDraughtIsMoved() {
    // @formatter:off
    Game game = this.gameBuilder.rows(
                                      " n      ", 
                                      "        ", 
                                      "        ", 
                                      "        ", 
                                      "        ",
                                      "        ", 
                                      "        ", 
                                      "B       ")
                                  .build();
    // @formatter:on
    Coordinate origin = new Coordinate(7, 0);
    Coordinate target = new Coordinate(4, 3);

    game.move(origin, target);

    assertNull(game.getPiece(origin));
    assertNotNull(game.getPiece(target));

  }

  @Test
  public void testGivenGameWhenMoveBackwardsThenDraughtIsMoved() {
    // @formatter:off
    Game game = this.gameBuilder.rows(
                                      " n      ", 
                                      "        ", 
                                      "        ", 
                                      "        ", 
                                      "   B    ",
                                      "        ", 
                                      "        ", 
                                      "        ")
                                  .build();
    // @formatter:on
    Coordinate origin = new Coordinate(4, 3);
    Coordinate target = new Coordinate(7, 0);

    game.move(origin, target);

    assertEquals(game.getPiece(origin), null);
    assertNotNull(game.getPiece(target));

  }


  @Test
  public void testGivenGameWhenDraughtMoveThenEats() {
    // @formatter:off
    Game game = this.gameBuilder.rows(
                                      " n      ", 
                                      "        ", 
                                      "        ", 
                                      "        ", 
                                      "        ",
                                      "        ", 
                                      " n      ", 
                                      "B       ")
                                .build();
    // @formatter:on

    Coordinate origin = new Coordinate(7, 0);
    Coordinate target = new Coordinate(5, 2);
    Coordinate eaten = new Coordinate(6, 1);

    game.move(origin, target);

    assertNull(game.getPiece(origin));
    assertNotNull(game.getPiece(target));
    assertNull(game.getPiece(eaten));

  }

  @Test
  public void testGivenGameWhenDraughtMoveThenEatsMultiSquare() {
    // @formatter:off
    Game game = this.gameBuilder.rows(
                                      " n      ", 
                                      "        ", 
                                      "        ", 
                                      "        ", 
                                      "        ",
                                      "  n     ", 
                                      "        ", 
                                      "B       ")
                                .build();
    // @formatter:on

    Coordinate origin = new Coordinate(7, 0);
    Coordinate target = new Coordinate(4, 3);
    Coordinate eaten = new Coordinate(5, 2);

    game.move(origin, target);

    assertNull(game.getPiece(origin));
    assertNotNull(game.getPiece(target));
    assertNull(game.getPiece(eaten));

  }

  @Test
  public void testGivenGameWhenDraughtMoveThenMultiEats() {
    // @formatter:off
    Game game = this.gameBuilder.rows(
                                      " n      ", 
                                      "        ", 
                                      "        ", 
                                      "        ", 
                                      "   n    ",
                                      "        ", 
                                      " n      ", 
                                      "B       ")
                                .build();
    // @formatter:on

    Coordinate origin = new Coordinate(7, 0);
    Coordinate eaten = new Coordinate(6, 1);
    Coordinate target = new Coordinate(5, 2);
    Coordinate eaten2 = new Coordinate(4, 3);
    Coordinate target2 = new Coordinate(3, 4);

    assertNotNull(game.getPiece(origin));
    assertNull(game.getPiece(target));
    assertNotNull(game.getPiece(eaten));
    assertNotNull(game.getPiece(eaten2));
    assertNull(game.getPiece(target2));

    game.move(origin, target, target, target2);
    assertEquals(game.getTurnColor(), Color.WHITE);

  }



}
