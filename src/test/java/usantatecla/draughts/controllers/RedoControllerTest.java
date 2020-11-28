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
public class RedoControllerTest {

  @InjectMocks
  private RedoController redoController;

  @Mock
  private Session session;

  @Before
  public void before() {
    this.redoController = new RedoController(this.session);
  }

  @Test
  public void testGivenUndoControllerWhenRedoThenOk() {
    redoController.redo();
    verify(this.session).redo();
  }
}
