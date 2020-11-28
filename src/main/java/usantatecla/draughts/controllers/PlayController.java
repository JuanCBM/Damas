package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.Session;

public class PlayController extends UseCaseController implements AcceptorController {

  private static final int MINIMUM_COORDINATES = 2;
  private UndoController undoController;

  public PlayController(Session session) {
    super(session);
    this.undoController = new UndoController(session);

  }

  public Error move(Coordinate... coordinates) {
    assert coordinates.length >= MINIMUM_COORDINATES;
    for (Coordinate coordinate : coordinates)
      assert coordinate != null;
    Error error = this.session.move(coordinates);
    if (this.session.isBlocked())
      this.session.next();
    return error;
  }

  public void cancel() {
    this.session.cancel();
    this.session.next();
  }

  public Color getColor() {
    return this.session.getTurnColor();
  }

  public boolean isBlocked() {
    return this.session.isBlocked();
  }

  @Override
  public void accept(InteractorControllersVisitor controllersVisitor) {
    assert controllersVisitor != null;
    controllersVisitor.visit(this);
  }

  public void undo() {
    this.undoController.undo();
  }

}
