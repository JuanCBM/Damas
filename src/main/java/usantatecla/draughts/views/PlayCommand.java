package usantatecla.draughts.views;

import usantatecla.draughts.controllers.PlayController;

public class PlayCommand extends Command {

  PlayCommand(PlayController playController) {
    super(Message.ACTION_COMMAND.getMessage(), playController);
  }

  public void execute() {
    // TODO Auto-generated method stub

  }

  public boolean isActive() {
    return true;
  }

}
