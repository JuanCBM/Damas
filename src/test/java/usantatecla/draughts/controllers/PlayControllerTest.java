package usantatecla.draughts.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.GameBuilder;
import usantatecla.draughts.models.State;

//@formatter:off
public class PlayControllerTest {

  private PlayController playController;
  private GameBuilder gameBuilder;

  @Before
  public void prepareGameBuilder() {
    this.gameBuilder = new GameBuilder();
  }
  
  @Test
  public void testGivenPlayControllerWhenMoveThenOk() {
    Game game = this.gameBuilder.build();
    playController = new PlayController(game, new State());
    
    Coordinate origin = new Coordinate(5, 0);
    Coordinate target = new Coordinate(4, 1);
  
    playController.move(origin, target);
   
    assertEquals(playController.getColor(target), Color.WHITE);
    assertFalse(game.isBlocked());
  }

  @Test
  public void testGivenPlayControllerWhenMoveWithoutPiecesThenIsBlocked() {
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      " n      ",
                                      "b       ",
                                      "        ",
                                      "        ")
                                .build();
    playController = new PlayController(game, new State());
   
    Coordinate origin = new Coordinate(5, 0);
    Coordinate target = new Coordinate(3, 2);
    
    playController.move(origin, target);
   
    assertEquals(playController.getColor(target), Color.WHITE);
    assertTrue(game.isBlocked());
  }

  @Test
  public void testGivenPlayControllerWhenMoveWithoutMovementsThenIsBlocked() {
    Game game = this.gameBuilder.rows(
                                      "        ",
                                      "        ",
                                      "   n    ",
                                      "  b b   ",
                                      "     b  ",
                                      "b       ",
                                      "        ",
                                      "        ")
                                .build();
    playController = new PlayController(game, new State());
   
    Coordinate origin = new Coordinate(5, 0);
    Coordinate target = new Coordinate(4, 1);
    
    playController.move(origin, target);
    
    assertEquals(playController.getColor(target), Color.WHITE);
    assertTrue(game.isBlocked());
  }

  @Test
  public void testGivenPlayControllerWhenCancelThenOk() {
    Game game = this.gameBuilder.build();
    playController = new PlayController(game, new State());
   
    playController.cancel();
   
    assertEquals(Color.BLACK, playController.getColor());
    assertFalse(game.isBlocked());
  }
  
  @Test
  public void testGivenPlayControllerWhenIsBlockedThenOk() {
    Game game = this.gameBuilder.build();
    assertFalse(new PlayController(game, new State()).isBlocked());
  }

  @Test(expected = AssertionError.class)
  public void testGivenPlayControllerWhenAcceptThenError() {
    Game game = this.gameBuilder.build();
    playController = new PlayController(game, new State());
    playController.accept(null);
  }

}
