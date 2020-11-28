package usantatecla.draughts.views;

import usantatecla.draughts.controllers.PlayController;

abstract class Command extends usantatecla.draughts.utils.Command {

  protected PlayController playController;

  protected Command(String title, PlayController playController) {
    super(title);
    this.playController = playController;
  }


}
