package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;

public abstract class InteractorController extends Controller {

  protected InteractorController(Game game, State state) {
    super(game, state);
  }

  public abstract void control();

}
