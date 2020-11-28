package usantatecla.draughts.controllers;


import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.Session;
import usantatecla.draughts.models.State;
import usantatecla.draughts.models.StateValue;

public class ResumeControllerTest {

  private State state;
  private ResumeController resumeController;

  @Before
  public void before() {
    this.state = new State();
    this.resumeController = new ResumeController(new Session());
  }

  @Test
  public void givenResumeControllerWhenResumeGameMoveToInitialStateRequiereCorrectThenNotError() {
    assertEquals(StateValue.IN_GAME, this.state.getValueState());
    resumeController.next();
    assertEquals(StateValue.FINAL, this.state.getValueState());
    resumeController.reset();
    assertEquals(StateValue.EXIT, this.state.getValueState());
  }

  @Test(expected = AssertionError.class)
  public void givenResumeControllerWhenResumeGameMoveOutThenError() {
    assertEquals(StateValue.IN_GAME, this.state.getValueState());
    resumeController.next();
    assertEquals(StateValue.FINAL, this.state.getValueState());
    resumeController.next();
    assertEquals(StateValue.EXIT, this.state.getValueState());
    resumeController.next();
  }

  @Test(expected = AssertionError.class)
  public void testGivenResumeControllerWhenAcceptThenError() {
    this.resumeController.accept(null);
  }

}
