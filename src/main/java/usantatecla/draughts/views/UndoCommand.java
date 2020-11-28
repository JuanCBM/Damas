package usantatecla.draughts.views;

import usantatecla.draughts.controllers.PlayController;

public class UndoCommand extends Command {

  protected UndoCommand(PlayController playController) {
    super(Message.UNDO_COMMAND.getMessage(), playController);
  }

  @Override
  public void execute() {
    this.playController.undo();
  }

  @Override
  public boolean isActive() {
    return this.playController.undoable();
  }

}
