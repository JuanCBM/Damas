package usantatecla.draughts.models;

public class ColorFactory {

  public static Color getInitialColor(Coordinate coordinate) {
    if (coordinate.isBlack())
      for (ColorPalette colorPalette : ColorPalette.values())
        if (colorPalette.isInitialRow(coordinate.getRow()))
          return colorPalette;
    return NullColor.NULL;
  }


}
