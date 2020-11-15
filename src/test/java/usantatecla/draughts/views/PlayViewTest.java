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
  public void testGivenPlayControllerWhenInteractThenIsNotDiagonalThenOk() {
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

  @Test(expected = AssertionError.class)
  public void testGivenNullPlayControllerWhenInteractThenError() {
    playView.interact(null);
    verify(playController).cancel();
  }

  @Test
  public void testGivenPlayViewWhenInteractThenCancel() {
    when(playController.getColor()).thenReturn(Color.BLACK);
    when(console.readString("Mueven las negras: ")).thenReturn("-1").thenReturn("32.41");
    playView.interact(playController);
    verify(playController).cancel();
  }

  @Test
  public void testGivenPlayViewWhenInteractWithEmptyThenError() {
    when(playController.getColor()).thenReturn(Color.BLACK);
    when(console.readString("Mueven las negras: ")).thenReturn("").thenReturn("32.41");
    playView.interact(playController);
    verify(playController).move(new Coordinate(2, 1), new Coordinate(3, 0));
  }

  @Test
  public void testGivenPlayViewWhenInteractWithNotPointThenError() {
    when(playController.getColor()).thenReturn(Color.BLACK);
    when(console.readString("Mueven las negras: ")).thenReturn("87,68").thenReturn("32.41");
    playView.interact(playController);
    verify(playController).move(new Coordinate(2, 1), new Coordinate(3, 0));
  }


  @Test
  public void testGivenPlayViewWhenInteractWithBadFormatThenError() {
    when(playController.getColor()).thenReturn(Color.BLACK);
    when(console.readString("Mueven las negras: ")).thenReturn("a3.42").thenReturn("32.41");
    playView.interact(playController);
    verify(playController).move(new Coordinate(2, 1), new Coordinate(3, 0));
  }

  @Test
  public void testGivenPlayViewWhenInteractWithBadRangeThenError() {
    when(playController.getColor()).thenReturn(Color.BLACK);
    when(console.readString("Mueven las negras: ")).thenReturn("93.49").thenReturn("32.41");
    playView.interact(playController);
    verify(playController).move(new Coordinate(2, 1), new Coordinate(3, 0));
  }

  @Test
  public void testGivenPlayViewWhenInteractWithNegativeThenError() {
    when(playController.getColor()).thenReturn(Color.BLACK);
    when(console.readString("Mueven las negras: ")).thenReturn("43.-34").thenReturn("32.41");
    playView.interact(playController);
    verify(playController).move(new Coordinate(2, 1), new Coordinate(3, 0));
  }

  @Test
  public void testGivenPlayViewWhenInteractWithSecondNegativeThenError() {
    when(playController.getColor()).thenReturn(Color.BLACK);
    when(console.readString("Mueven las negras: ")).thenReturn("4-3.34").thenReturn("32.41");
    playView.interact(playController);
    verify(playController).move(new Coordinate(2, 1), new Coordinate(3, 0));
  }

  @Test
  public void testGivenPlayViewWhenInteractWithTwoCoordiantesThenOk() {
    when(playController.getColor()).thenReturn(Color.BLACK);
    when(console.readString("Mueven las negras: ")).thenReturn("32.41");
    playView.interact(playController);
    verify(playController).move(new Coordinate(2, 1), new Coordinate(3, 0));
  }

  @Test
  public void testGivenPlayViewWhenInteractWithThirdCoordiantesThenOk() {
    when(playController.getColor()).thenReturn(Color.BLACK);
    when(console.readString("Mueven las negras: ")).thenReturn("23.32.41");
    playView.interact(playController);
    verify(playController).move(
        new Coordinate(1, 2),
        new Coordinate(2, 1),
        new Coordinate(3, 0));
  }
}
