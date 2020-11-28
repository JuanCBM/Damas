package usantatecla.draughts.controllers;


import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import usantatecla.draughts.models.Session;

@RunWith(MockitoJUnitRunner.class)
public class ResumeControllerTest {

  @InjectMocks
  private ResumeController resumeController;

  @Mock
  private Session session;

  @Before
  public void before() {
    this.resumeController = new ResumeController(this.session);
  }

  @Test
  public void givenResumeControllerWhenNextThenOk() {
    resumeController.next();
    verify(this.session).next();
  }

  @Test
  public void givenResumeControllerWhenResetThenOk() {
    resumeController.reset();
    verify(this.session).reset();
  }

  @Test(expected = AssertionError.class)
  public void testGivenPlayControllerWhenAcceptThenError() {
    resumeController.accept(null);
  }

}
