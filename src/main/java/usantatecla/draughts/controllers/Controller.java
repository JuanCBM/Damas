package usantatecla.draughts.controllers;

import usantatecla.draughts.models.ColorGlobal;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;

class Controller {

  protected Game game;
  protected State state;

  protected Controller(Game game, State state) {
    assert game != null;
    assert state != null;
    this.game = game;
    this.state = state;
  }

  public ColorGlobal getColor(Coordinate coordinate) {
    assert coordinate != null;
    return this.game.getColor(coordinate);
  }

  public int getDimension() {
    return this.game.getDimension();
  }

}
