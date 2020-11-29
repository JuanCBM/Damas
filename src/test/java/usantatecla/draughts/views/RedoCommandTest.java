package usantatecla.draughts.views;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import usantatecla.draughts.controllers.PlayController;

@RunWith(MockitoJUnitRunner.class)
public class RedoCommandTest {

  @InjectMocks
  RedoCommand redoCommand = new RedoCommand(this.playController);

  @Mock
  PlayController playController;

  @Test
  public void testRedoCommandWhenExecuteThenOk() {
    doNothing().when(this.playController).redo();
    this.redoCommand.execute();
    verify(this.playController).redo();
  }

  @Test
  public void testRedoCommandWhenIsActiveThenOk() {
    doReturn(true).when(this.playController).redoable();
    assertTrue(this.redoCommand.isActive());
  }

}
