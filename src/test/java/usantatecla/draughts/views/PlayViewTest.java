package usantatecla.draughts.views;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
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
  public void testInteract(){
    when(playController.getColor()).thenReturn(Color.BLACK);
    when(console.readString("Mueven las negras: ")).thenReturn("32.41\n");
    playView.interact(playController);
    verify(playController).move(new Coordinate(3,2), new Coordinate(4, 1));
  }

  @Test
  public void testGivenPlayViewWhenPlayerGiveUpThenNextState(){
    when(playController.getColor()).thenReturn(Color.WHITE);
    when(console.readString("Mueven las blancas: ")).thenReturn("-1");
    playView.interact(playController);
    verify(playController).cancel();
  }

  @Test
  public void testGivenPlayViewWherGameIsOverThenNextState(){
    when(playController.getColor()).thenReturn(Color.WHITE);
    when(playController.isBlocked()).thenReturn(true);
    playView.interact(playController);
    //verify(playController).();
  }

}
