package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.javatuples.Pair;
import org.junit.Test;

public class DirectionTest {

  @Test
  public void testDirectionWhenIsOnDirectionCoordinateNEIsOnDirectionThenOk() {
    Coordinate coordinate = new Coordinate(2, 2);
    assertTrue(Direction.NE.isOnDirection(coordinate));
  }

  @Test
  public void testDirectionWhenIsOnDirectionCoordinateSEIsOnDirectionThenOk() {
    Coordinate coordinate = new Coordinate(-2, 2);
    assertTrue(Direction.SE.isOnDirection(coordinate));
  }

  @Test
  public void testDirectionWhenIsOnDirectionCoordinateSWIsOnDirectionThenOk() {
    Coordinate coordinate = new Coordinate(-2, -2);
    assertTrue(Direction.SW.isOnDirection(coordinate));
  }

  @Test
  public void testDirectionWhenIsOnDirectionCoordinateNWIsOnDirectionThenOk() {
    Coordinate coordinate = new Coordinate(2, -2);
    assertTrue(Direction.NW.isOnDirection(coordinate));
  }

  @Test
  public void testGivenDistanceGetDistanceCoordinateThenOk() {
    Coordinate coordinate = new Coordinate(2, -2);
    assertEquals(Direction.NW.getDistanceCoordinate(2), coordinate);
  }

  @Test
  public void testDirectionWhenIsOnDirectionCoordinateThenOk() {
    List<Pair<Coordinate, Direction>> orioginDestinationExpectedDirection =
        Arrays.asList(new Pair<>(new Coordinate(2, 2), Direction.NE),
            new Pair<>(new Coordinate(-2, 2), Direction.SE),
            new Pair<>(new Coordinate(-2, -2), Direction.SW),
            new Pair<>(new Coordinate(2, -2), Direction.NW));
    for (Pair<Coordinate, Direction> duplet : orioginDestinationExpectedDirection) {
      assertTrue(duplet.getValue1().isOnDirection(duplet.getValue0()));
    }
  }

  @Test
  public void testGivenDirectionGetDistanceCoordinateThenOk() {
    List<Pair<Coordinate, Direction>> orioginDestinationExpectedDirection =
        Arrays.asList(new Pair<>(new Coordinate(2, 2), Direction.NE),
            new Pair<>(new Coordinate(-2, 2), Direction.SE),
            new Pair<>(new Coordinate(-2, -2), Direction.SW),
            new Pair<>(new Coordinate(2, -2), Direction.NW));
    for (Pair<Coordinate, Direction> duplet : orioginDestinationExpectedDirection) {
      assertEquals(duplet.getValue1().getDistanceCoordinate(2), duplet.getValue0());
    }

  }

}
