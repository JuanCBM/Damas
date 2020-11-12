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
    this.resumeView.interact(resumeController);
    when(this.yesNoDialog.read(Mockito.anyString())).thenReturn(true);
    verify(this.resumeController).reset();
  }

  @Test
  public void testGivenResumeViewWhenInteractThenNext() {
    this.resumeView.interact(resumeController);
    when(this.yesNoDialog.read(Mockito.anyString())).thenReturn(false);
    verify(this.resumeController).next();
  }

  @Test(expected = AssertionError.class)
  public void testGivenResumeViewWhenInteractThenError() {
    this.resumeView.interact(null);
  }

}
