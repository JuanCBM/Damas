package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class CoordinateTest {

  @Test
  public void testGivenRowColumnWhenCoordinateThenOk() {
    int row = 4;
    int column = 5;
    Coordinate coordinate = new Coordinate(row, column);

    assertEquals(coordinate.getRow(), row);
    assertEquals(coordinate.getColumn(), column);

  }

  @Test
  public void testGivenCoordinateWhenGetInstanceIsOk() {
    assertEquals(Coordinate.getInstance("61"), new Coordinate(5, 0));
  }

  @Test
  public void testGivenCoordinateWhenGetInstanceIsExistingOk() {
    Coordinate.getInstance("61,23");
    assertEquals(Coordinate.getInstance("61"), new Coordinate(5, 0));
  }

  @Test
  public void testGivenCoordinateWhenGetDirectionThenOk() {
    Coordinate coordinate = new Coordinate(1, 1);
    Coordinate coordinate2 = new Coordinate(2, 2);
    coordinate.getDirection(coordinate2);
    assertEquals(coordinate.getDirection(coordinate2), Direction.NE);
  }

  @Test
  public void testGivenCoordinateWhenIsDiagonalThenIsDiagonal() {
    Coordinate coordinate = new Coordinate(1, 1);
    Coordinate coordinate2 = new Coordinate(2, 2);

    assertTrue(coordinate.isOnDiagonal(coordinate2));
  }

  @Test
  public void testGivenCoordinateWhenIsDiagonalThenIsNotDiagonal() {
    Coordinate coordinate = new Coordinate(1, 1);
    Coordinate coordinate2 = new Coordinate(2, 1);

    assertFalse(coordinate.isOnDiagonal(coordinate2));
  }

  @Test
  public void testGivenCoordinateWhenGetDiagonalThenOk() {
    Coordinate coordinate = new Coordinate(1, 1);
    Coordinate coordinate2 = new Coordinate(2, 2);

    assertEquals(coordinate.getDiagonalDistance(coordinate2), 1);
  }


  @Test(expected = AssertionError.class)
  public void testGivenCoordinateWhenGetDiagonalThenIsNotDiagonal() {
    Coordinate coordinate = new Coordinate(1, 1);
    Coordinate coordinate2 = new Coordinate(2, 1);
    coordinate.getDiagonalDistance(coordinate2);
  }

  @Test
  public void testGivenCoordinateWhenGetBetweenDiagonalCoordinateThenOk() {
    Coordinate coordinate = new Coordinate(1, 1);
    Coordinate coordinate2 = new Coordinate(3, 3);

    Coordinate coordinateBetween = new Coordinate(2, 2);

    assertEquals(coordinate.getBetweenDiagonalCoordinate(coordinate2), coordinateBetween);
  }

  @Test(expected = AssertionError.class)
  public void testGivenCoordinateWhenGetBetweenDiagonalCoordinateThenMoreThanOne() {
    Coordinate coordinate = new Coordinate(1, 1);
    Coordinate coordinate2 = new Coordinate(7, 7);

    coordinate.getBetweenDiagonalCoordinate(coordinate2);
  }


  @Test(expected = AssertionError.class)
  public void testGivenCoordinateWhenGetDiagonalCoordinatesThenIsNotDiagonal() {
    Coordinate coordinate = new Coordinate(1, 1);
    Coordinate coordinate2 = new Coordinate(2, 3);
    coordinate.getBetweenDiagonalCoordinates(coordinate2);
  }

  @Test
  public void testGivenCoordinateWhenGetDiagonalCoordinatesThenIsOne() {
    Coordinate coordinate = new Coordinate(1, 1);
    Coordinate coordinate2 = new Coordinate(3, 3);

    Coordinate coordinateBetween = new Coordinate(2, 2);
    List<Coordinate> coordinates = new ArrayList<>();
    coordinates.add(coordinateBetween);

    assertEquals(coordinate.getBetweenDiagonalCoordinates(coordinate2), coordinates);
  }

  @Test
  public void testGivenCoordinateWhenGetDiagonalCoordinatesThenIsList() {
    Coordinate coordinate = new Coordinate(1, 1);
    Coordinate coordinate2 = new Coordinate(4, 4);

    Coordinate coordinateBetween = new Coordinate(2, 2);
    Coordinate coordinateBetween2 = new Coordinate(3, 3);

    List<Coordinate> coordinates = new ArrayList<>();
    coordinates.add(coordinateBetween);
    coordinates.add(coordinateBetween2);

    assertEquals(coordinate.getBetweenDiagonalCoordinates(coordinate2), coordinates);

  }


  @Test
  public void testGivenLevelWhenGetDiagonalCoordinatesThenOk() {
    List<Coordinate> coordinates = new ArrayList<>();
    Coordinate coordinate = new Coordinate(1, 1);

    Coordinate coordinateDiagonal4 = new Coordinate(0, 0);
    Coordinate coordinateDiagonal1 = new Coordinate(2, 2);
    Coordinate coordinateDiagonal2 = new Coordinate(0, 2);
    Coordinate coordinateDiagonal3 = new Coordinate(2, 0);

    coordinates.add(coordinateDiagonal1);
    coordinates.add(coordinateDiagonal2);
    coordinates.add(coordinateDiagonal3);
    coordinates.add(coordinateDiagonal4);

    assertEquals(coordinates.size(), coordinate.getDiagonalCoordinates(1).size());
    for (Coordinate c : coordinate.getDiagonalCoordinates(1)) {
      assertTrue(coordinates.contains(c));
    }

  }

  @Test
  public void testGivenCoordinateWhenIsBlackThenTrue() {
    Coordinate coordinate = new Coordinate(0, 1);
    assertTrue(coordinate.isBlack());
  }

  @Test
  public void testGivenCoordinateWhenIsBlackThenFalse() {
    Coordinate coordinate = new Coordinate(0, 0);
    assertFalse(coordinate.isBlack());
  }


  @Test
  public void testGivenCoordinateWhenIsLastThenTrue() {
    Coordinate coordinate = new Coordinate(7, 1);
    assertTrue(coordinate.isLast());
  }

  @Test
  public void testGivenCoordinateWhenIsLastThenFalse() {
    Coordinate coordinate = new Coordinate(0, 0);
    assertFalse(coordinate.isLast());
  }

  @Test
  public void testGivenCoordinateWhenIsFirstThenTrue() {
    Coordinate coordinate = new Coordinate(0, 1);
    assertTrue(coordinate.isFirst());
  }

  @Test
  public void testGivenCoordinateWhenIsFirstThenFalse() {
    Coordinate coordinate = new Coordinate(4, 0);
    assertFalse(coordinate.isFirst());
  }

  @Test
  public void testGivenCoordinateGetDimensionOk() {
    assertEquals(Coordinate.getDimension(), 8);
  }

}
