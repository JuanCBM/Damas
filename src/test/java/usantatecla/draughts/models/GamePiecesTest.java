package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class GamePiecesTest {

  Game game;

  @Test
  public void testWhenResetThenRecolocatePieces() {
    this.game = new GameBuilder().rows("        ", "        ", "        ", "       n", "        ",
        "        ", "        ", "n       ").build();
    this.game.reset();
    System.out.print(this.game);
    assertEquals(color(coordinate(7, 0)), ColorPalette.WHITE);
    assertNotEquals(color(coordinate(3, 7)), ColorPalette.BLACK);
    assertNotEquals(color(coordinate(3, 7)), ColorPalette.WHITE);
  }

  @Test
  public void testWhenCancelThenRemovePiecesAndChangeTurn() {
    this.game = new GameBuilder().rows("        ", "        ", "        ", "       b", "        ",
        "        ", "        ", "b       ").build();
    this.game.cancel();
    assertNotEquals(color(coordinate(3, 7)), ColorPalette.BLACK);
    assertNotEquals(color(coordinate(3, 7)), ColorPalette.WHITE);
    assertEquals(this.game.getTurnColor(), ColorPalette.BLACK);
  }

  @Test
  public void tesGetNullPiece() {
    this.game = new GameBuilder().rows("        ", "        ", "        ", "       b", "        ",
        "        ", "        ", "b       ").build();
    assertNull(piece(coordinate(3, 4)));
  }

  private Coordinate coordinate(int row, int column) {
    return new Coordinate(row, column);
  }

  private Color color(Coordinate coordinate) {
    return this.game.getColor(coordinate);
  }

  private Piece piece(Coordinate coordinate) {
    return this.game.getPiece(coordinate);
  }
}
