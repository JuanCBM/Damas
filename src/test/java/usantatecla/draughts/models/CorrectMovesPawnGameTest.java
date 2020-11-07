package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class CorrectMovesPawnGameTest {

  GameBuilder gameBuilder;

  @Before
  public void prepareGameBuilder() {
    this.gameBuilder = new GameBuilder();
  }

  @Test
  public void testGivenGameWhenMoveThenPawntIsMoved() {
    // @formatter:off
    Game game = this.gameBuilder.rows(
                                      " n      ", 
                                      "        ", 
                                      "        ", 
                                      "        ", 
                                      "        ",
                                      "        ", 
                                      "        ", 
                                      "b       ")
                                  .build();
    // @formatter:on
    Coordinate origin = new Coordinate(7, 0);
    Coordinate target = new Coordinate(6, 1);

    game.move(origin, target);

    assertNull(game.getPiece(origin));
    assertNotNull(game.getPiece(target));

  }

  @Test
  public void testGivenGameWhenPawnMoveThenDraught() {
    // @formatter:off
    Game game = this.gameBuilder.rows(
                                      " n      ", 
                                      "  b     ", 
                                      "        ", 
                                      "        ", 
                                      "        ",
                                      "        ", 
                                      "        ", 
                                      "b       ")
                                  .build();
    // @formatter:on
    Coordinate origin = new Coordinate(1, 2);
    Coordinate target = new Coordinate(0, 3);

    game.move(origin, target);

    assertEquals(game.getPiece(target).getClass(), Draught.class);

  }

  @Test
  public void testGivenGameWhenPawnMoveThenEats() {
    // @formatter:off
    Game game = this.gameBuilder.rows(
                                      " n      ", 
                                      "        ", 
                                      "        ", 
                                      "        ", 
                                      "        ",
                                      "        ", 
                                      " n      ", 
                                      "b       ")
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

  // TODO: Fix multi eating
  @Test
  public void testGivenGameWhenPawnMoveThenMultiEats() {
    // @formatter:off
    Game game = this.gameBuilder.rows(
                                      " n      ", 
                                      "        ", 
                                      "        ", 
                                      "        ", 
                                      "   n    ",
                                      "        ", 
                                      " n      ", 
                                      "b       ")
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

    game.move(origin, target, target2);
    System.out.print(game);

    assertEquals(game.getTurnColor(), Color.BLACK);

  }

  @Test
  public void testGivenGameWhenWhiteMovesThenIsBlackTurn() {
    Game game = this.gameBuilder.rows(GameBuilder.INITIAL_BOARD).color(Color.WHITE).build();
    Coordinate origin = new Coordinate(5, 0);
    Coordinate target = new Coordinate(4, 1);

    game.move(origin, target);

    assertEquals(game.getTurnColor(), Color.BLACK);
  }

  @Test
  public void testGivenGameWhenBlackMovesThenIsWhiteTurn() {
    Game game = this.gameBuilder.rows(GameBuilder.INITIAL_BOARD).color(Color.BLACK).build();
    Coordinate origin = new Coordinate(2, 1);
    Coordinate target = new Coordinate(3, 2);

    game.move(origin, target);

    assertEquals(game.getTurnColor(), Color.WHITE);
  }

}
