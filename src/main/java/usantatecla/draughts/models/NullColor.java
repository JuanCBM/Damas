package usantatecla.draughts.models;

public enum NullColor implements Color {
  NULL;

  @Override
  public Color getInitialColor(Coordinate coordinate) {
    return NULL;
  }

  @Override
  public boolean isNull() {
    return true;
  }

}
