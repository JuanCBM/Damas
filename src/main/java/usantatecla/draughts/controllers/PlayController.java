package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.Session;

public class PlayController extends UseCaseController implements AcceptorController {

  private ActionController actionController;
  private UndoController undoController;
  private RedoController redoController;

  public PlayController(Session session) {
    super(session);
    this.actionController = new ActionController(session);
    this.undoController = new UndoController(session);
    this.redoController = new RedoController(session);
  }

  @Override
  public void accept(InteractorControllersVisitor controllersVisitor) {
    assert controllersVisitor != null;
    controllersVisitor.visit(this);
  }

  public Error move(Coordinate... coordinates) {
    return this.actionController.move(coordinates);
  }

  public void cancel() {
    this.actionController.cancel();
  }

  public Color getColor() {
    return this.actionController.getColor();
  }

  public boolean isBlocked() {
    return this.actionController.isBlocked();
  }

  public void undo() {
    this.undoController.undo();
  }

  public void redo() {
    this.redoController.redo();
  }

  public boolean undoable() {
    return this.undoController.undoable();
  }

  public boolean redoable() {
    return this.redoController.redoable();
  }


}
