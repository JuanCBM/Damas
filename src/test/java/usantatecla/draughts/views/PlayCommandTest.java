package usantatecla.draughts.views;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
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
    doNothing().when(this.playController).redo();
    this.playCommand.execute();
    verify(this.playController).redo();
  }

  @Test
  public void testPlayCommandWhenIsActiveThenOk() {
    doReturn(true).when(this.playController).redoable();
    assertTrue(this.playCommand.isActive());
  }

}
