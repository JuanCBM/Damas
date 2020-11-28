package usantatecla.draughts.controllers;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.GameBuilder;
import usantatecla.draughts.models.GameRegistry;
import usantatecla.draughts.models.State;

public class UndoControllerTest {

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
    State state = new State();
    GameRegistry registry = new GameRegistry(this.game);
    this.game.getBoard().move(new Coordinate(5, 0), new Coordinate(4, 1));

    UndoController undoController = new UndoController(this.game, registry, state);
    undoController.undo();

    assertEquals(this.game.getBoard(), game(GameBuilder.INITIAL_BOARD).getBoard());

  }
}
