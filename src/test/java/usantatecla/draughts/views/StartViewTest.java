package usantatecla.draughts.views;

import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import usantatecla.draughts.controllers.StartController;
import usantatecla.draughts.utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class StartViewTest {

  @Mock
  StartController startController;

  @Mock
  Console console;

  @InjectMocks
  StartView startView;

  @Test
  public void testGivenStartViewWhenInteractThenNoError() {
    this.startView.interact(startController);

    verify(this.startController).start();
    verify(console).writeln(Mockito.anyString());
  }

}
