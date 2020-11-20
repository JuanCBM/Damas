package usantatecla.draughts.models;

public enum ColorPalette implements Color {
  WHITE, BLACK;

  final int[] LIMITS = new int[] {5, 2};

  @Override
  public Color getInitialColor(final Coordinate coordinate) {
    if (coordinate.isBlack())
      for (ColorPalette colorPalette : ColorPalette.values())
        if (colorPalette.isInitialRow(coordinate.getRow()))
          return colorPalette;
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

  @Override
  public boolean isNull() {
    return false;
  }
}
