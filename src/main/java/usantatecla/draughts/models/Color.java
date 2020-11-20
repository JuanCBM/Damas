package usantatecla.draughts.models;

public enum Color implements ColorGlobal {
  WHITE, BLACK;

  final int[] LIMITS = new int[] {5, 2};

  @Override
  public ColorGlobal getInitialColor(final Coordinate coordinate) {
    if (coordinate.isBlack())
      for (Color color : Color.values())
        if (color.isInitialRow(coordinate.getRow()))
          return color;
    return NullColor.NULL;
  }

  boolean isInitialRow(final int row) {
    switch (this) {
      case WHITE:
        return row >= LIMITS[this.ordinal()];
      case BLACK:
        return row <= LIMITS[this.ordinal()];
    }
    return false;
  }
}
