// package usantatecla.draughts.models;
//
// public class GameBuilder {
//
// Game game;
// Board board;
//
// public GameBuilder() {
// this.board = new Board();
// this.game = new Game(this.board);
// }
//
// public GameBuilder rows(String... rows) {
// assert rows.length == Coordinate.getDimension();
// for (int i = 0; i < rows.length; i++) {
// String row = rows[i];
// assert row.length() == Coordinate.getDimension();
// for (int j = 0; j < row.length(); j++) {
// PaletteColor paletteColor = paletteColor(row.charAt(j));
// if (paletteColor != null) {
// Piece piece = new Pawn(paletteColor);
// if (Character.isUpperCase(row.charAt(j))) {
// piece = new Draught(paletteColor);
// }
// this.board.put(new Coordinate(i, j), piece);
// }
// }
// }
// return this;
// }
//
// private PaletteColor paletteColor(char color) {
// switch(color) {
// case 'b':
// case 'B':
// return PaletteColor.WHITE;
// case 'n':
// case 'N':
// return PaletteColor.BLACK;
// default:
// return null;
// }
// }
//
// public Game build() {
// return this.game;
// }
// }
