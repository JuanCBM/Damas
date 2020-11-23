package usantatecla.draughts;

import usantatecla.draughts.controllers.Controller;
import usantatecla.draughts.controllers.Logic;

class Draughts {

  private Logic logic;

  private Draughts() {
    this.logic = new Logic();
  }

  private void play() {
    Controller controller;
    do {
      controller = this.logic.getController();
      if (controller != null)
        controller.control();
    } while (controller != null);
  }

  public static void main(String[] args) {
    new Draughts().play();
  }

}
