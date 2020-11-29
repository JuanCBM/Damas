package usantatecla.draughts.views;

import usantatecla.draughts.controllers.PlayController;

class PlayView extends SubView {

  private static final String TITTLE = "Draughts";

  PlayView() {
    super();
    this.console.writeln(TITTLE);
  }

  void interact(PlayController playController) {
    new PlayMenu(playController).execute();
    new GameView().write(playController);

  }


}
