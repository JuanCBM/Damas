package usantatecla.draughts.models;

import org.junit.Assert;
import org.junit.Test;

public class ColorTest {
  PaletteColor white = PaletteColor.WHITE;
  PaletteColor black = PaletteColor.BLACK;

  @Test
  public void testIsInitialRow() {
    Assert.assertTrue(black.isInitialRow(0));
    Assert.assertTrue(black.isInitialRow(2));
    Assert.assertFalse(black.isInitialRow(3));

    Assert.assertTrue(white.isInitialRow(5));
    Assert.assertTrue(white.isInitialRow(8));
  }

  @Test
  public void testGetInitialColorWhenCoordinateIsOnInitialRowsShouldReturnColor() {
    Assert.assertEquals(black, ColorFactory.getInitialColor(coordinate(0, 1)));
    Assert.assertEquals(white, ColorFactory.getInitialColor(coordinate(5, 0)));
  }

  @Test
  public void testGetInitialColorWhenCoordinateIsWhiteShouldReturnNull() {
    Assert.assertEquals(NullColor.NULL, ColorFactory.getInitialColor(coordinate(0, 0)));
    Assert.assertEquals(NullColor.NULL, ColorFactory.getInitialColor(coordinate(2, 2)));
  }

  @Test
  public void testGetInitialColorWhenCoordinateDoesntHavePieceShouldReturnNull() {
    Assert.assertEquals(NullColor.NULL, ColorFactory.getInitialColor(coordinate(3, 3)));
    Assert.assertEquals(NullColor.NULL, ColorFactory.getInitialColor(coordinate(4, 4)));
  }

  private static Coordinate coordinate(int row, int column) {
    return new Coordinate(row, column);
  }
}
