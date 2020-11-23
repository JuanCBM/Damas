package usantatecla.draughts.views;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.models.PaletteColor;
import usantatecla.draughts.utils.Console;

public class PlayViewTest {

  private static final String CANCEL_FORMAT = "-1";
  private static final String LOST_MESSAGE = "Derrota!!! No puedes mover tus fichas!!!";

  @Mock
  Console console;

  @Mock
  PlayController playController;

  @Before
  public void before() {
    initMocks(this);
    doReturn(PaletteColor.WHITE).when(playController).getColor();
  }

  @Test
  public void testWhenIntroducingCancelFormatThenCancelInvoked() {
    // TODO: Preguntar por qué con el @Spy de console no funciona el when().thenReturn()
    doReturn(CANCEL_FORMAT).when(console).readString(any());
    // when(console.readString(anyString())).thenReturn(CANCEL_FORMAT);
    // playView.interact(playController);
    verify(playController, times(1)).cancel();
  }

  @Test
  public void testWhenIntroducingWrongFormatCoordinateThenAskAgain() {
    doReturn("xxx", "12.23").when(console).readString(any());
    // playView.interact(playController);
    verify(console, times(2)).readString(any());
  }

  @Test
  public void testWhenIntroducingValidCoordinateAndBlockedThenLoose() {
    doReturn("12.23").when(console).readString(any());
    // doReturn(true).when(playController).isBlocked();
    // playView.interact(playController);
    verify(console, times(1)).writeln(LOST_MESSAGE);
  }
}
