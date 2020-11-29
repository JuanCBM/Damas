package usantatecla.draughts.views;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import usantatecla.draughts.controllers.PlayController;

@RunWith(MockitoJUnitRunner.class)
public class PlayViewTest {

  @InjectMocks
  PlayView playView;

  @Mock
  PlayMenu playMenu = new PlayMenu(this.playController);

  @Mock
  GameView gameView;

  @Mock
  PlayController playController;

  @Test
  public void testPlayViewWhenInteractThenOk() {
    // this.playView.interact(playController);
  }
}
