package usantatecla.draughts.models;

public enum NullColor implements ColorGlobal {
  NULL;

  @Override
  public ColorGlobal getInitialColor(Coordinate coordinate) {
    return NULL;
  }

}
