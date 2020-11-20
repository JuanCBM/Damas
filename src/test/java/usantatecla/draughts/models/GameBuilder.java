package usantatecla.draughts.models;

public class GameBuilder {

	Game game;
	Board board;
	
	public GameBuilder() {
		this.board = new Board();
		this.game = new Game(this.board);
	}
	
	public GameBuilder rows(String... rows) {
		assert rows.length == Coordinate.getDimension();
		for (int i = 0; i < rows.length; i++) {
			String row = rows[i];
			assert row.length() == Coordinate.getDimension();
			for (int j = 0; j < row.length(); j++) {
				PaletteColor color = color(row.charAt(j));
				if (color != null) {
					Piece piece = new Pawn(color);
					if (Character.isUpperCase(row.charAt(j))) {
						piece = new Draught(color);
					}
					this.board.put(new Coordinate(i, j), piece);
				}
			}
		}
		return this;
	}
	
	private PaletteColor color(char color) {
		switch(color) {
		case 'b':
		case 'B':
			return PaletteColor.WHITE;
		case 'n':
		case 'N':
			return PaletteColor.BLACK;
		default:
			return null;
		}
	}
	
	public Game build() {
		return this.game;
	}
}
