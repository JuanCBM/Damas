package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Color;
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

  public Color getColor(Coordinate coordinate) {
    assert coordinate != null;
    return this.session.getColor(coordinate);
  }

  public int getDimension() {
    return this.session.getDimension();
  }

}
