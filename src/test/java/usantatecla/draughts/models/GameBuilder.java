package usantatecla.draughts.models;

public class GameBuilder {

  private Turn turn;
  private Board board;

  public GameBuilder() {
    this.board = new Board();
    this.turn = new Turn();
  }

  public Game build() {
    return new Game(this.board);
  }

  public GameBuilder color(Color color) {
    this.turn = new Turn();
    if (color == Color.BLACK) {
      this.turn.change();
    }
    return this;
  }

  public GameBuilder rows(String... rows) {
    for (int i = 0; i < rows.length; i++) {
      this.setRow(board, i, rows[i]);
    }
    return this;
  }

  private void setRow(Board board, int row, String string) {
    for (int j = 0; j < string.length(); j++) {
      Color color = this.getColor(string.charAt(j));
      if (color != null) {
        Piece piece = new Pawn(color);
        if (Character.isUpperCase(string.charAt(j))) {
          piece = new Draught(color);
        }
        board.put(new Coordinate(row, j), piece);
      }
    }
  }

  private Color getColor(char character) {
    switch (character) {
      case 'b':
      case 'B':
        return Color.WHITE;
      case 'n':
      case 'N':
        return Color.BLACK;
      default:
        return null;
    }
  }

}
