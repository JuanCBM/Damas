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
public class UndoCommandTest {

  @InjectMocks
  UndoCommand undoCommand;

  @Mock
  PlayController playController;

  @Before
  public void prepareGameBuilder() {
    this.undoCommand = new UndoCommand(this.playController);
  }

  @Test
  public void testUndoCommandWhenExecuteThenOk() {
    doNothing().when(this.playController).undo();
    this.undoCommand.execute();
    verify(this.playController).undo();
  }

  @Test
  public void testUndoCommandWhenIsUndoableThenOk() {
    doReturn(true).when(this.playController).undoable();
    assertTrue(this.undoCommand.isUndoable());
  }

}
