package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Session;

public class UndoController extends UseCaseController {

  UndoController(Session session) {
    super(session);
  }

  public void undo() {
    this.session.undo();
  }

  public boolean undoable() {
    return this.session.undoable();
  }

}
