package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;

public abstract class Controller {

  protected Game game;
  protected State state;

  Controller(Game game, State state) {
    assert game != null;
    assert state != null;
    this.game = game;
    this.state = state;
  }

  public abstract void control();

}
