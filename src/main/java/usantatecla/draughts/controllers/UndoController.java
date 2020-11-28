package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Session;

public class UndoController extends UseCaseController {

  UndoController(Session session) {
    super(session);
  }

  void undo() {
    this.session.undo();
  }

}
