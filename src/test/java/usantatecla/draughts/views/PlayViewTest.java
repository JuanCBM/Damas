package usantatecla.draughts.views;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Error;
import usantatecla.draughts.utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class PlayViewTest {

  @Mock
  PlayController playController;

  @Mock
  Console console;

  @InjectMocks
  PlayView playView;

  @Test
  public void testGivenPlayControllerWhenInteractThenNoError() {
    when(playController.getColor()).thenReturn(Color.BLACK);
    when(console.readString(Mockito.anyString())).thenReturn("32.41");
    when(playController.move(Mockito.any(), Mockito.any())).thenReturn(null);
    when(playController.isBlocked()).thenReturn(false);

    playView.interact(playController);
    verify(playController).move(new Coordinate(2, 1), new Coordinate(3, 0));
  }

  @Test
  public void testGivenPlayControllerWhenInteractThenIsBlocked() {
    when(playController.getColor()).thenReturn(Color.BLACK);
    when(console.readString(Mockito.anyString())).thenReturn("32.41");
    when(playController.move(Mockito.any(), Mockito.any())).thenReturn(null);
    when(playController.isBlocked()).thenReturn(true);

    playView.interact(playController);
    verify(playController).move(new Coordinate(2, 1), new Coordinate(3, 0));
  }

  @Test
  public void testGivenPlayControllerWhenInteractThenIsNotDiagonal() {
    when(playController.getColor()).thenReturn(Color.BLACK);
    when(console.readString(Mockito.anyString())).thenReturn("32.41").thenReturn("21.31");
    when(playController.move(Mockito.any(), Mockito.any())).thenReturn(Error.NOT_DIAGONAL)
        .thenReturn(null);
    when(playController.isBlocked()).thenReturn(false);

    playView.interact(playController);

    verify(playController).move(new Coordinate(2, 1), new Coordinate(3, 0));
    verify(playController).move(new Coordinate(1, 0), new Coordinate(2, 0));

  }


  @Test
  public void testGivenPlayControllerWhenInteractThenBadFormat() {
    when(playController.getColor()).thenReturn(Color.BLACK);
    when(console.readString(Mockito.anyString())).thenReturn("09.41\n").thenReturn("32.41");
    playView.interact(playController);
    verify(playController).move(new Coordinate(2, 1), new Coordinate(3, 0));
  }

  @Test
  public void testGivenPlayControllerWhenInteractThenCancelFormat() {
    when(playController.getColor()).thenReturn(Color.WHITE);
    when(console.readString(Mockito.anyString())).thenReturn("-1");
    playView.interact(playController);
    verify(playController).cancel();
  }


  @Test(expected = AssertionError.class)
  public void testGivenNullPlayControllerWhenInteractThenError() {
    playView.interact(null);
    verify(playController).cancel();
  }
}
