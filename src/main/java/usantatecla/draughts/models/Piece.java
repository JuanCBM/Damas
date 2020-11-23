package usantatecla.draughts.models;

import java.util.List;

public abstract class Piece {

  protected Color color;
  private static String[] CODES = {"b", "n"};

  Piece(Color color) {
    assert (!color.isNull());
    this.color = color;
  }

  Error isCorrectMovement(List<Piece> betweenDiagonalPieces, Coordinate origin, Coordinate target) {
    assert origin != null;
    assert target != null;
    if (!origin.isOnDiagonal(target))
      return Error.NOT_DIAGONAL;
    for (Piece piece : betweenDiagonalPieces)
      if (this.color == piece.getColor())
        return Error.COLLEAGUE_EATING;
    return this.isCorrectDiagonalMovement(betweenDiagonalPieces.size(), origin, target);
  }

  abstract Error isCorrectDiagonalMovement(int amountBetweenDiagonalPieces, Coordinate origin,
      Coordinate target);

  boolean isLimit(Coordinate coordinate) {
    return coordinate.isFirst() && this.getColor() == PaletteColor.WHITE
        || coordinate.isLast() && this.getColor() == PaletteColor.BLACK;
  }

  boolean isAdvanced(Coordinate origin, Coordinate target) {
    assert origin != null;
    assert target != null;
    int difference = origin.getRow() - target.getRow();

    return PaletteColor.WHITE.equals(color) ? difference > 0 : difference < 0;
  }

  public Color getColor() {
    return this.color;
  }

  @Override
  public String toString() {
    return this.getCode();
  }

  public String getCode() {
    return Piece.CODES[this.color.ordinal()];
  }

  public abstract Piece copy();

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((color == null) ? 0 : color.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Piece other = (Piece) obj;
    if (color != other.color)
      return false;
    return true;
  }

}
