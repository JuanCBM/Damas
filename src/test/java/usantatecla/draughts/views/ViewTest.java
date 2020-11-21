package usantatecla.draughts.views;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import usantatecla.draughts.controllers.InteractorController;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.utils.YesNoDialog;

public class ViewTest {

  @Mock
  private PlayView playView;

  @Mock
  private YesNoDialog yesNoDialog;

  @InjectMocks
  private final View view = new View();

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testVisitPlayViewVerifyInteractOnce() {
    PlayController playController = mock(PlayController.class);
    this.view.visit(playController);
    verify(this.playView, times(1)).interact(playController);
    verifyNoMoreInteractions(playController);
  }

  @Test
  public void testVisitResumeVerifyInteractOnceReset() {
    ResumeController resumeController = mock(ResumeController.class);
    doReturn(true).when(this.yesNoDialog).read(Mockito.anyString());
    this.view.visit(resumeController);
    verify(resumeController, times(1)).reset();
    verifyNoMoreInteractions(resumeController);
  }

  @Test
  public void testVisitResumeVerifyInteractOnceNext() {
    ResumeController resumeController = mock(ResumeController.class);
    doReturn(false).when(this.yesNoDialog).read(Mockito.anyString());
    this.view.visit(resumeController);
    verify(resumeController, times(1)).next();
    verifyNoMoreInteractions(resumeController);
  }


  @Test
  public void testInteractControllerVerifyAcceptOnce() {
    InteractorController interactorController = mock(InteractorController.class);
    this.view.interact(interactorController);
    verify(interactorController, times(1)).accept(this.view);
    verifyNoMoreInteractions(interactorController);
  }

  @Test(expected = AssertionError.class)
  public void testVisitWithNullPlayControllerShouldThrowAssertionError() {
    this.view.visit((PlayController) null);
  }

  @Test(expected = AssertionError.class)
  public void testVisitWithNullResumeControllerShouldThrowAssertionError() {
    this.view.visit((ResumeController) null);
  }

  @Test(expected = AssertionError.class)
  public void testInteractWithNullControllerShouldThrowAssertionError() {
    this.view.interact(null);
  }
}
