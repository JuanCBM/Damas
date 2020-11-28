package usantatecla.draughts.views;

import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import usantatecla.draughts.controllers.UndoController;

@RunWith(MockitoJUnitRunner.class)
public class UndoCommandTest {

  @InjectMocks
  UndoCommand undoCommand;

  @Mock
  UndoController undoController;

  @Test
  public void testUndoCommandWhenExecuteThenOk() {
    this.undoController.execute();
    verify(this.undoController).undo();
  }

}
