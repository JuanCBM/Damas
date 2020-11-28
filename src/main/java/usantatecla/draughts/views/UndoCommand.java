package usantatecla.draughts.views;

import usantatecla.draughts.controllers.PlayController;

public class UndoCommand {
  protected PlayController playController;

  protected UndoCommand(PlayController playController) {
    this.playController = playController;
  }

  public void execute() {
    this.playController.undo();
  }

}
