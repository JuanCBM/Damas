package usantatecla.draughts.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StateTest {

  private static State state;

  @Before
  public void before() {
    state = new State();
  }

  @Test
  public void testStateIsInitialStateWhenCreated() {
    Assert.assertEquals(getStateValue(0), state.getValueState());
  }

  @Test
  public void testNext() {
    state.next();
    Assert.assertEquals(getStateValue(1), state.getValueState());
    state.next();
    Assert.assertEquals(getStateValue(2), state.getValueState());
  }

  @Test(expected = AssertionError.class)
  public void testNextWhenStateValueIsExitShouldThrowsError() {
    this.advanceStateTo(StateValue.EXIT);
    state.next();
  }

  @Test
  public void testReset() {
    state.reset();
    Assert.assertEquals(getStateValue(0), state.getValueState());
  }

  private StateValue getStateValue(int position) {
    StateValue[] values = StateValue.values();
    return values[position];
  }

  private void advanceStateTo(StateValue stateValue) {
    while (state.getValueState() != stateValue) {
      state.next();
    }
  }
}
