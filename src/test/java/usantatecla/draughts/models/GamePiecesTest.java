package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class GamePiecesTest {

	Game game;
	
	@Test
	public void testWhenResetThenRecolocatePieces() {
		this.game = new GameBuilder().rows(
				"        ",
				"        ",
				"        ",
				"       n",
				"        ",
				"        ",
				"        ",
				"n       ").build();
		this.game.reset();
		assertEquals(color(coordinate(7, 0)), PaletteColor.WHITE);
		assertNotEquals(color(coordinate(3, 7)), PaletteColor.BLACK);
		assertNotEquals(color(coordinate(3, 7)), PaletteColor.WHITE);
	}
	
	@Test
	public void testWhenCancelThenRemovePiecesAndChangeTurn() {
		this.game = new GameBuilder().rows(
				"        ",
				"        ",
				"        ",
				"       b",
				"        ",
				"        ",
				"        ",
				"b       ").build();
		this.game.cancel();
		assertNotEquals(color(coordinate(3, 7)), PaletteColor.BLACK);
		assertNotEquals(color(coordinate(3, 7)), PaletteColor.WHITE);
		assertEquals(this.game.getTurnColor(), PaletteColor.BLACK);
	}
	
	@Test
	public void tesGetNullPiece() {
		this.game = new GameBuilder().rows(
				"        ",
				"        ",
				"        ",
				"       b",
				"        ",
				"        ",
				"        ",
				"b       ").build();
		assertNull(piece(coordinate(3, 4)));
	}
	
	private Coordinate coordinate(int row, int column) {
		return new Coordinate(row, column);
	}
	
	private PaletteColor color(Coordinate coordinate) {
		return this.game.getColor(coordinate);
	}
	
	private Piece piece(Coordinate coordinate) {
		return this.game.getPiece(coordinate);
	}
}
