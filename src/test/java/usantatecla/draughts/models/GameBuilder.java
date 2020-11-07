package usantatecla.draughts.models;

import java.util.HashMap;
import java.util.Map;

public class GameBuilder {

  private Turn turn;
  private Board board;

  private Map<Character, Piece> piecesMap = new HashMap<Character, Piece>() {
    private static final long serialVersionUID = 1L;
    {
      put('b', new Pawn(Color.WHITE));
      put('B', new Draught(Color.WHITE));
      put('n', new Pawn(Color.BLACK));
      put('N', new Draught(Color.BLACK));
    }
  };

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
      Piece piece = piecesMap.get(string.charAt(j));
      board.put(new Coordinate(row, j), piece);
    }
  }


}
