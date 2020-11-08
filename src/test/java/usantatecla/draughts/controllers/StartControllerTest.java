package usantatecla.draughts.controllers;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.GameBuilder;
import usantatecla.draughts.models.State;
import usantatecla.draughts.models.StateValue;

public class StartControllerTest {

  private State state;
  private StartController startController;

  @Before
  public void before() {
    Game game = new GameBuilder().build();
    this.state = new State();
    this.startController = new StartController(game, state);
  }

  @Test
  public void givenStartControllerWhenStartGameThenChangeState() {
    assertEquals(StateValue.INITIAL, state.getValueState());
    this.startController.start();
    assertEquals(StateValue.IN_GAME, state.getValueState());
  }

  @Test(expected = AssertionError.class)
  public void testStartControllerControllerWhenAcceptThenError() {
    this.startController.accept(null);
  }

  @Test
  public void testGivenStartControllerWhenGetDimentionThenOk() {
    assertEquals(this.startController.getDimension(), Coordinate.getDimension());
  }

  @Test(expected = AssertionError.class)
  public void testGivenStartControllerNullCoordinateWhenGetColorThenError() {
    this.startController.getColor(null);
  }

  @Test(expected = AssertionError.class)
  public void testGivenStartControllerCoordinateWhenGetColorThenOk() {
    assertEquals(this.startController.getColor(new Coordinate(0, 0)), Color.WHITE);
  }

}
