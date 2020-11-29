package usantatecla.draughts.views;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class PlayCommandTest {

  private static final String CANCEL_FORMAT = "-1";
  private static final String LOST_MESSAGE = "Derrota!!! No puedes mover tus fichas!!!";

  @Mock
  PlayController playController;

  @Mock
  Console console;

  @InjectMocks
  PlayCommand playCommand = new PlayCommand(this.playController);

  @Before
  public void before() {
    doReturn(Color.WHITE).when(playController).getColor();
  }

  @Test
  public void testPlayCommandWhenIsActiveThenOk() {
    assertTrue(this.playCommand.isActive());
  }

  @Test
  public void testWhenIntroducingCancelFormatThenCancelInvoked() {
    doReturn(CANCEL_FORMAT).when(console).readString(any());
    playCommand.execute();
    verify(playController, times(1)).cancel();
  }

  @Test
  public void testWhenIntroducingWrongFormatCoordinateThenAskAgain() {
    doReturn("xxx", "12.23").when(console).readString(any());
    playCommand.execute();
    verify(console, times(2)).readString(any());
  }

  @Test
  public void testWhenIntroducingValidCoordinateAndBlockedThenLoose() {
    doReturn("12.23").when(console).readString(any());
    doReturn(true).when(playController).isBlocked();
    playCommand.execute();
    verify(console, times(1)).writeln(LOST_MESSAGE);
  }

}
