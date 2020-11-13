package usantatecla.draughts.views;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.PieceBuilder;
import usantatecla.draughts.utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class GameViewTest {

  @Before
  public void prepareGameBuilder() {
    this.pieceBuilder = new PieceBuilder();
  }

  PieceBuilder pieceBuilder;

  @Mock
  Console console;

  @Mock
  PlayController playController;

  @InjectMocks
  GameView gameView;

  @Test
  public void testGivenPlayControllerWhenWriteThenNoError() {
    int dimension = 8;

    when(this.playController.getDimension()).thenReturn(dimension);
    doNothing().when(this.console).write(Mockito.anyString());

    this.gameView.write(playController);

  }

  @Test
  public void testGivenZeroDimentionWhenWriteThenNoError() {
    int dimension = 0;

    when(this.playController.getDimension()).thenReturn(dimension);
    doNothing().when(this.console).write(Mockito.anyString());

    this.gameView.write(playController);

  }

  @Test
  public void testGivenNegativeDimentionWhenWriteThenNoError() {
    int dimension = -10;

    when(this.playController.getDimension()).thenReturn(dimension);
    doNothing().when(this.console).write(Mockito.anyString());

    this.gameView.write(playController);

  }

  @Test
  public void testGivenPawnWhenWriteThenNoError() {
    int dimension = 8;

    when(this.playController.getDimension()).thenReturn(dimension);
    when(this.playController.getPiece(Mockito.any()))
        .thenReturn(pieceBuilder.piece("p").color(Color.WHITE).build());

    doNothing().when(this.console).write(Mockito.anyString());

    this.gameView.write(playController);

  }

  @Test
  public void testGivenDraugthWhenWriteThenNoError() {
    int dimension = 8;

    when(this.playController.getDimension()).thenReturn(dimension);
    when(this.playController.getPiece(Mockito.any()))
        .thenReturn(pieceBuilder.piece("d").color(Color.WHITE).build());

    doNothing().when(this.console).write(Mockito.anyString());

    this.gameView.write(playController);

  }

  @Test
  public void testGivenNullWhenWriteThenNoError() {
    int dimension = 8;

    when(this.playController.getDimension()).thenReturn(dimension);
    when(this.playController.getPiece(Mockito.any())).thenReturn(null);

    doNothing().when(this.console).write(Mockito.anyString());

    this.gameView.write(playController);

  }

}
