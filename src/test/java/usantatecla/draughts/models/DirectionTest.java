package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DirectionTest {

  @Test
  public void testGivenHorizontalVerticalShiftWhenCreateNEIsOnDirectionThenOk() {
    Coordinate coordinate = new Coordinate(2, 2);
    assertTrue(Direction.NE.isOnDirection(coordinate));
  }

  @Test
  public void testGivenHorizontalVerticalShiftWhenCreateSEIsOnDirectionThenOk() {
    Coordinate coordinate = new Coordinate(-2, 2);
    assertTrue(Direction.SE.isOnDirection(coordinate));
  }

  @Test
  public void testGivenHorizontalVerticalShiftWhenCreateSWIsOnDirectionThenOk() {
    Coordinate coordinate = new Coordinate(-2, -2);
    assertTrue(Direction.SW.isOnDirection(coordinate));
  }

  @Test
  public void testGivenHorizontalVerticalShiftWhenCreateNWIsOnDirectionThenOk() {
    Coordinate coordinate = new Coordinate(2, -2);
    assertTrue(Direction.NW.isOnDirection(coordinate));
  }


  @Test
  public void testGivenDistanceGetDistanceCoordinateThenOk() {
    Coordinate coordinate = new Coordinate(2, -2);
    assertEquals(Direction.NW.getDistanceCoordinate(2), coordinate);
  }

}
