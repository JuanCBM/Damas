package usantatecla.draughts.views;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.utils.Console;
import usantatecla.draughts.utils.YesNoDialog;

@RunWith(MockitoJUnitRunner.class)
public class ResumeViewTest {

  @Mock
  ResumeController resumeController;

  @Mock
  Console console;

  @Mock
  YesNoDialog yesNoDialog;

  @InjectMocks
  ResumeView resumeView;

  @Test
  public void testGivenResumeViewWhenInteractThenReset() {
    when(this.yesNoDialog.read(Mockito.anyString())).thenReturn(true);
    this.resumeView.interact(resumeController);
    verify(this.resumeController).reset();
  }

  @Test
  public void testGivenResumeViewWhenInteractThenNext() {
    when(this.yesNoDialog.read(Mockito.anyString())).thenReturn(false);
    this.resumeView.interact(resumeController);
    verify(this.resumeController).next();
  }

  @Test(expected = AssertionError.class)
  public void testGivenResumeViewWhenInteractThenError() {
    this.resumeView.interact(null);
  }

  @Test
  public void testWhenResumeViewThenOk() {
    this.resumeView = new ResumeView();

    verify(this.yesNoDialog);
  }

}
