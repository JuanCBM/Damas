package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Session;

public abstract class UseCaseController {

  protected Session session;

  UseCaseController(Session session) {
    this.session = session;
  }

}
