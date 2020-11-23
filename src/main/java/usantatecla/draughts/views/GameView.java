package usantatecla.draughts.views;

import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.Piece;

public class GameView extends SubView {

  public void write(Game game) {
    final int dimension = game.getDimension();
    this.writeNumbersLine(dimension);
    for (int i = 0; i < dimension; i++)
      this.writePiecesRow(i, game);
    this.writeNumbersLine(dimension);
  }

  private void writeNumbersLine(final int dimension) {
    this.console.write(" ");
    for (int i = 0; i < dimension; i++)
      this.console.write((i + 1) + "");
    this.console.writeln();
  }

  private void writePiecesRow(final int row, Game game) {
    this.console.write((row + 1) + "");
    for (int j = 0; j < game.getDimension(); j++) {
      Piece piece = game.getPiece(new Coordinate(row, j));
      if (piece == null)
        this.console.write(" ");
      else
        this.console.write(piece.getCode());
    }
    this.console.writeln((row + 1) + "");
  }

}
