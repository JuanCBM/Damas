package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;
import usantatecla.draughts.utils.YesNoDialog;

public class ResumeController extends Controller {

  private YesNoDialog yesNoDialog;
  private static final String MESSAGE = "¿Queréis jugar otra";

  public ResumeController(Game game, State state) {
    super(game, state);
    this.yesNoDialog = new YesNoDialog();
  }

  public void next() {
    this.state.next();
  }

  public void reset() {
    this.state.reset();
    this.game.reset();
  }

  @Override
  public void control() {
    if (this.yesNoDialog.read(MESSAGE))
      this.reset();
    else
      this.next();

  }



}
