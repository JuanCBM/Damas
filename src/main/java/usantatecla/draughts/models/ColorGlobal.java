package usantatecla.draughts.models;

public interface ColorGlobal {
  final int[] LIMITS = new int[] {5, 2};

  public ColorGlobal getInitialColor(Coordinate coordinate);

  public int ordinal();
}
