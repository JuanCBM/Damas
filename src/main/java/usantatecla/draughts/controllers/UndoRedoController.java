package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Session;

public class UndoRedoController extends UseCaseController {

  UndoRedoController(Session session) {
    super(session);
  }

  void undo() {
    this.session.undo();
  }

  public void redo() {
    this.session.redo();
  }

}
