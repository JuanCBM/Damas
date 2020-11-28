package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.GameRegistry;
import usantatecla.draughts.models.State;

public class UndoRedoController {

  private Game game;
  private GameRegistry registry;
  private State state;

  public UndoRedoController(Game game, GameRegistry registry, State state) {
    this.state = new State();
    this.game = new Game();
    this.registry = registry;
  }

  public void undo() {
    this.registry.undo();
  }

  public void redo() {
    this.registry.redo();
  }


}
