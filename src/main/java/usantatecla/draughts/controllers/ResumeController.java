package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Session;

public class ResumeController extends UseCaseController implements AcceptorController {

  ResumeController(Session session) {
    super(session);
  }

  public void next() {
    this.session.next();
  }

  public void reset() {
    this.session.reset();
  }

  @Override
  public void accept(InteractorControllersVisitor controllersVisitor) {
    assert controllersVisitor != null;
    controllersVisitor.visit(this);
  }

}
