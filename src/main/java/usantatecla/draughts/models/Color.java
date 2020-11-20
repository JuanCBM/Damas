package usantatecla.draughts.models;

public interface Color {

  public Color getInitialColor(Coordinate coordinate);

  public boolean isNull();

  public int ordinal();
}
