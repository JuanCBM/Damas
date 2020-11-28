package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Session;

public class RedoController extends UseCaseController {

  RedoController(Session session) {
    super(session);
  }

  public void redo() {
    this.session.redo();
  }

}
