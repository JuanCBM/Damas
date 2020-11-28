package usantatecla.draughts.controllers;

import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import usantatecla.draughts.models.Session;

@RunWith(MockitoJUnitRunner.class)
public class UndoRedoControllerTest {

  @InjectMocks
  private UndoRedoController undoRedoController;

  @Mock
  private Session session;

  @Before
  public void before() {
    this.undoRedoController = new UndoRedoController(this.session);
  }

  @Test
  public void testGivenUndoControllerWhenUndoThenOk() {

    undoRedoController.undo();
    verify(this.session).undo();
  }

  @Test
  public void testGivenUndoControllerWhenRedoThenOk() {
    undoRedoController.redo();
    verify(this.session).redo();

  }
}
