package usantatecla.draughts.models;

public class ColorFactory {
  public static final Color[] colors = {Color.WHITE, Color.WHITE};


  public static ColorGlobal getInitialColor(Coordinate coordinate) {
    if (coordinate.isBlack())
      for (Color color : Color.values())
        if (color.isInitialRow(coordinate.getRow()))
          return color;


    return NullColor.NULL;
  }


}
