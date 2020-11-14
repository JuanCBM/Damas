package usantatecla.draughts.views;

import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.controllers.StartController;

@RunWith(MockitoJUnitRunner.class)
public class ViewTest {

  @Mock
  private ResumeController resumeController;

  @Mock
  private PlayController playController;

  @Mock
  private StartController startController;

  @Mock
  private ResumeView resumeView;

  @Mock
  private PlayView playView;

  @Mock
  private StartView startView;

  @InjectMocks
  View view;

  @Test(expected = AssertionError.class)
  public void testGivenViewWhenInteractThenError() {
    this.view.interact(null);
  }

  @Test
  public void testGivenViewWhenInteractThenOk() {
    this.view.interact(playController);
    verify(this.playController).accept(this.view);
  }

  @Test
  public void testGivenViewWhenVisitResumeControllerThenOk() {
    this.view.visit(resumeController);
    verify(this.resumeView).interact(resumeController);
  }

  @Test
  public void testGivenViewWhenVisitPlayControllerThenOk() {
    this.view.visit(playController);
    verify(this.playView).interact(playController);
  }

  @Test
  public void testGivenViewWhenVisitStartControllerThenOk() {
    this.view.visit(startController);
    verify(this.startView).interact(startController);
  }

  @Test(expected = AssertionError.class)
  public void testGivenViewWhenVisitNullPlayControllerThenError() {
    PlayController playController = null;
    this.view.visit(playController);
  }

  @Test(expected = AssertionError.class)
  public void testGivenViewWhenVisitNullStartControllerThenError() {
    StartController startController = null;
    this.view.visit(startController);
  }

  @Test(expected = AssertionError.class)
  public void testGivenViewWhenVisitNullResumeControllerThenError() {
    ResumeController resumeController = null;
    this.view.visit(resumeController);
  }

}
