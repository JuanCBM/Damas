package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Piece;
import usantatecla.draughts.models.Session;

public abstract class UseCaseController {

  protected Session session;

  UseCaseController(Session session) {
    this.session = session;
  }

  public Piece getPiece(Coordinate coordinate) {
    return this.session.getPiece(coordinate);
  }

  public int getDimension() {
    return this.session.getDimension();
  }

}
