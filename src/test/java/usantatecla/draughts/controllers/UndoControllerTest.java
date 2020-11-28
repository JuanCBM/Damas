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
public class UndoControllerTest {

  @InjectMocks
  private UndoController undoController;

  @Mock
  private Session session;

  @Before
  public void before() {
    this.undoController = new UndoController(this.session);
  }

  @Test
  public void testGivenUndoControllerWhenUndoThenOk() {
    undoController.undo();
    verify(this.session).undo();
  }

}
