package usantatecla.draughts.models;

public class PieceBuilder {

  private String type;
  private Color color;

  public PieceBuilder() {
    this.type = "p";
    this.color = Color.WHITE;
  }

  public PieceBuilder color(Color color) {
    this.color = color;
    return this;
  }

  public PieceBuilder piece(String type) {
    this.type = type;
    return this;
  }

  public Piece build() {
    assert (this.color != null);
    if (this.type == "p") {
      return new Pawn(this.color);
    } else if (this.type == "d") {
      return new Draught(this.color);
    }
    return null;
  }
}
