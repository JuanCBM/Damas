package usantatecla.draughts.models;

public class PieceBuilder extends DraughtUtils {

  private Character piece;

  public PieceBuilder piece(Character piece) {
    this.piece = piece;
    return this;
  }

  public Piece build() {
    assert (piecesMap.get(this.piece) != null);

    return piecesMap.get(this.piece);
  }
}
