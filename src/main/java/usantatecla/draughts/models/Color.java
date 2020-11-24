package usantatecla.draughts.models;

public enum Color {
  WHITE, BLACK, NULL;

  final int[] LIMITS = new int[] {5, 2};

  public static Color getInitialColor(final Coordinate coordinate) {
    if (coordinate.isBlack())
      for (Color paletteColor : Color.values())
        if (paletteColor.isInitialRow(coordinate.getRow()))
          return paletteColor;
    return NULL;
  }

  boolean isInitialRow(final int row) {
    switch (this) {
      case WHITE:
        return row >= LIMITS[this.ordinal()];
      case BLACK:
        return row <= LIMITS[this.ordinal()];
      case NULL:
        return row < LIMITS[WHITE.ordinal()] && row > LIMITS[BLACK.ordinal()];
    }
    return false;
  }

  public boolean isNull() {
    switch (this) {
      case WHITE:
      case BLACK:
        return false;
      case NULL:
      default:
        return true;
    }
  }
}
