package usantatecla.draughts.controllers;

import java.util.HashMap;
import java.util.Map;
import usantatecla.draughts.models.Session;
import usantatecla.draughts.models.StateValue;

public class Logic {

  private Session session;
  private Map<StateValue, AcceptorController> controllers;

  public Logic() {
    this.session = new Session();
    this.initializeController();
  }

  public AcceptorController getController() {
    return this.controllers.get(this.session.getValueState());
  }

  private void initializeController() {
    this.controllers = new HashMap<StateValue, AcceptorController>();
    this.controllers.put(StateValue.IN_GAME, new PlayController(this.session));
    this.controllers.put(StateValue.FINAL, new ResumeController(this.session));
    this.controllers.put(StateValue.EXIT, null);
  }

}
