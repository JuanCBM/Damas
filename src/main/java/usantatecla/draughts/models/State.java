package usantatecla.draughts.models;

public class State {

  private StateValue stateValue;

  public State() {
    this.reset();
  }

  public void next() {
    assert !StateValue.EXIT.equals(this.stateValue);
    this.stateValue = StateValue.values()[this.stateValue.ordinal() + 1];
  }

  public void reset() {
    this.stateValue = StateValue.IN_GAME;
  }

  public StateValue getValueState() {
    return this.stateValue;
  }
}
