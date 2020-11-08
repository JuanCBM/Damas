package usantatecla.draughts.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class GameBuilder {

  private final List<String> strings;
  private Color color;

  public GameBuilder() {
    this.color = null;
    this.strings = new ArrayList<>();
  }

  // @formatter:off
  public static String[] INITIAL_BOARD = {" n n n n",
                                          "n n n n ", 
                                          " n n n n", 
                                          "        ", 
                                          "        ",
                                          "b b b b ", 
                                          " b b b b", 
                                          "b b b b "};
  //@formatter:on

  private final Map<Character, Piece> piecesMap = new HashMap<Character, Piece>() {
    private static final long serialVersionUID = 1L;
    {
      put('b', new Pawn(Color.WHITE));
      put('B', new Draught(Color.WHITE));
      put('n', new Pawn(Color.BLACK));
      put('N', new Draught(Color.BLACK));
    }
  };

  public Game build() {
    if (this.strings.size() == 0)
      return new Game();

    Board board = new Board();
    Game game = new Game(board);
    if (this.color != null) {
      this.setColor(game, board);
    }
    assert this.strings.size() == Coordinate.getDimension();
    for (int i = 0; i < this.strings.size(); i++) {
      this.setRow(board, i, this.strings.get(i));
    }

    return game;
  }

  public GameBuilder color(Color color) {
    this.color = color;
    return this;
  }

  public GameBuilder rows(String... rows) {
    for (String string : rows) {
      assert Pattern.matches("[bBnN ]{8}", string);
      this.strings.add(string);
    }
    return this;
  }

  private void setRow(Board board, int row, String string) {
    for (int j = 0; j < string.length(); j++) {
      Piece piece = piecesMap.get(string.charAt(j));
      board.put(new Coordinate(row, j), piece);
    }
  }

  private void setColor(Game game, Board board) {
    if (this.color == Color.BLACK) {
      board.put(new Coordinate(7, 0), new Pawn(Color.WHITE));
      game.move(new Coordinate(7, 0), new Coordinate(6, 1));
      board.remove(new Coordinate(6, 1));
    }
  }
}
