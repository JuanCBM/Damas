package usantatecla.draughts.controllers;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Session;

@RunWith(MockitoJUnitRunner.class)
public class PlayControllerTest {

  @InjectMocks
  private PlayController playController;

  @Mock
  private Session session;

  private Coordinate[] coordinates;

  @Before
  public void prepareGameBuilder() {
    this.playController = new PlayController(this.session);
    coordinates = new Coordinate[] {new Coordinate(5, 0), new Coordinate(4, 1)};
  }

  @Test
  public void testGivenPlayControllerWhenMoveThenOk() {
    when(this.session.move(coordinates)).thenReturn(null);
    when(this.session.isBlocked()).thenReturn(false);

    assertNull(playController.move(coordinates));
  }

  @Test
  public void testGivenPlayControllerWhenMoveIsBlockedThenOk() {
    when(this.session.move(coordinates)).thenReturn(null);
    when(this.session.isBlocked()).thenReturn(true);

    assertNull(playController.move(coordinates));
    verify(this.session).next();
  }

  @Test
  public void testGivenPlayControllerWhenCancelThenOk() {
    playController.cancel();
    verify(this.session).cancel();
    verify(this.session).next();
  }

  @Test
  public void testGivenPlayControllerWhenGetColorThenOk() {
    playController.getColor();
    verify(this.session).getTurnColor();
  }

  @Test
  public void testGivenPlayControllerWhenIsBlockedThenOk() {
    playController.isBlocked();
    verify(this.session).isBlocked();
  }

  @Test(expected = AssertionError.class)
  public void testGivenPlayControllerWhenAcceptThenError() {
    playController.accept(null);
  }

}
