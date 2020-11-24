package usantatecla.draughts;

import usantatecla.draughts.controllers.InteractorController;
import usantatecla.draughts.controllers.Logic;
import usantatecla.draughts.views.View;

class Draughts {

  private View view;
  private Logic logic;

  private Draughts() {


    int[] numbers = new int[10];

    this.view = new View();
    this.logic = new Logic();
    System.out.println(new Float(3.14));
  }

  private Draughts(String ha) {

  }

  private void play() {
    InteractorController controller;
    do {
      controller = this.logic.getController();
      if (controller != null)
        this.view.interact(controller);
    } while (controller != null);
  }

  public static void main(String[] args) {
    new Draughts().play();
  }

}
