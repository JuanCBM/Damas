package usantatecla.draughts.models;

public enum PaletteColor implements Color {
  WHITE, BLACK;

  final int[] LIMITS = new int[] {5, 2};

  @Override
  public Color getInitialColor(final Coordinate coordinate) {
    if (coordinate.isBlack())
      for (PaletteColor paletteColor : PaletteColor.values())
        if (paletteColor.isInitialRow(coordinate.getRow()))
          return paletteColor;
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
