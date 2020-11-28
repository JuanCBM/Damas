package usantatecla.draughts.views;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import usantatecla.draughts.controllers.PlayController;

@RunWith(MockitoJUnitRunner.class)
public class PlayCommandTest {

  @InjectMocks
  PlayCommand playCommand;

  @Mock
  PlayController playController;

  @Before
  public void setUp() {
    this.playCommand = new PlayCommand(this.playController);
  }

  @Test
  public void testPlayCommandWhenExecuteThenOk() {
    this.playCommand.execute();
  }

  @Test
  public void testPlayCommandWhenIsActiveThenOk() {
    assertTrue(this.playCommand.isActive());
  }

}
