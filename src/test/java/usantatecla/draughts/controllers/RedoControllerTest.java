package usantatecla.draughts.controllers;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.GameBuilder;
import usantatecla.draughts.models.GameRegistry;
import usantatecla.draughts.models.State;

public class RedoControllerTest {

  Game game;

  @Before
  public void before() {
    this.game = game(GameBuilder.INITIAL_BOARD);
  }

  private static Game game(String... rows) {
    return new GameBuilder().rows(rows).build();
  }

  @Test
  public void testGivenUndoControllerWhenUndoThenIsCorrect() {
    GameRegistry registry = new GameRegistry(this.game);
    // @formatter:off
    Game gameAfterMove = game(  " n n n n",
                                "n n n n ", 
                                " n n n n", 
                                "        ", 
                                " b      ",
                                "  b b b ", 
                                " b b b b", 
                                "b b b b ");
    // @formatter:on

    this.game.getBoard().move(new Coordinate(5, 0), new Coordinate(4, 1));

    registry.register();

    UndoController undoController = new UndoController(this.game, registry, new State());
    undoController.undo();

    undoController.redo();

    assertEquals(this.game.getBoard(), gameAfterMove.getBoard());

  }
}
