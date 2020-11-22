package usantatecla.draughts.models;

public class ColorFactory {

  public static Color getInitialColor(Coordinate coordinate) {
    if (coordinate.isBlack())
      for (PaletteColor paletteColor : PaletteColor.values())
        if (paletteColor.isInitialRow(coordinate.getRow()))
          return paletteColor;

    return NullColor.NULL;
  }

}
