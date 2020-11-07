package usantatecla.draughts.models;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class IsBlockedGameTest {

  GameBuilder gameBuilder;

  @Before
  public void prepareGameBuilder() {
    this.gameBuilder = new GameBuilder();
  }

  @Test
  public void testGivenGameWhenPawnMoveThenWins() {
    // @formatter:off
    Game game = this.gameBuilder.rows(
                                      "        ", 
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

    assertNotNull(game.getPiece(origin));
    assertNull(game.getPiece(target));
    assertNotNull(game.getPiece(eaten));

    game.move(origin, target);

    assertTrue(game.isBlocked());

  }

  @Test
  public void testGivenGameWhenDraughtMoveThenWins() {
    // @formatter:off
    Game game = this.gameBuilder.rows(
                                      "        ", 
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

    assertNotNull(game.getPiece(origin));
    assertNull(game.getPiece(target));
    assertNotNull(game.getPiece(eaten));

    game.move(origin, target);

    assertTrue(game.isBlocked());

  }

}
