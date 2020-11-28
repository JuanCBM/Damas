package usantatecla.draughts.views;

import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.utils.Menu;

public class PlayMenu extends Menu {

  PlayMenu(PlayController playController) {
    this.addCommand(new PlayCommand(playController));
    this.addCommand(new UndoCommand(playController));
    this.addCommand(new RedoCommand(playController));
  }

}
