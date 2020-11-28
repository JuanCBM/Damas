package usantatecla.draughts.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class YesNoDialogTest {

  @InjectMocks
  private YesNoDialog yesNoDialog;

  @Mock
  Console console;

  private final char AFFIRMATIVE = 'y';
  private final char NEGATIVE = 'n';
  private final String ERROR = "The value must be '" + AFFIRMATIVE + "' or '" + NEGATIVE + "'";

  @Test(expected = AssertionError.class)
  public void testReadWhenTitleIsNull() {
    this.yesNoDialog.read(null);
  }

  @Test
  public void testAnswerYes() {
    when(this.console.readChar(any())).thenReturn(this.AFFIRMATIVE);
    assertTrue(this.yesNoDialog.read("title"));
  }

  @Test
  public void testAnswerNo() {
    when(this.console.readChar(any())).thenReturn(this.NEGATIVE);
    assertFalse(this.yesNoDialog.read("title"));
  }

  @Test
  public void testWrongAnswer() {
    when(this.console.readChar(any())).thenReturn('x', this.NEGATIVE);
    this.yesNoDialog.read("title");
    verify(console, times(1)).writeln(ERROR);
  }
}
