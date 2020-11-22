package usantatecla.draughts.models;

import java.util.ArrayList;
import java.util.List;

public class Game {

  private Board board;
  private Turn turn;

  Game(Board board) {
    this.turn = new Turn();
    this.board = board;
  }

  public Game() {
    this(new Board());
    this.reset();
  }

  public void reset() {
    for (int i = 0; i < Coordinate.getDimension(); i++)
      for (int j = 0; j < Coordinate.getDimension(); j++) {
        Coordinate coordinate = new Coordinate(i, j);
        Piece piece = this.getInitialPiece(coordinate);
        this.board.put(coordinate, piece);
      }
    if (this.turn.getColor() != PaletteColor.WHITE)
      this.turn.change();
  }

  public Error move(Coordinate... coordinates) {
    Error error = null;
    List<Coordinate> removedCoordinates = new ArrayList<Coordinate>();
    List<Piece> removedPieces = new ArrayList<Piece>();
    int pair = 0;

    GameMemento gameMemento = this.createMemento();

    ValidatorErrorMove validatorErrorMove = null;
    do {
      // error = this.isCorrectPairMove(pair, coordinates);
      validatorErrorMove = new ValidatorErrorMove(this.board, this.turn, pair, coordinates);
      error = validatorErrorMove.checkError();
      if (error == null) {
        this.pairMove(removedCoordinates, removedPieces, pair, coordinates);
        pair++;
      }
    } while (pair < coordinates.length - 1 && error == null);
    validatorErrorMove.setRemovedSize(removedCoordinates.size());
    error = validatorErrorMove.checkGlobalError(validatorErrorMove.checkError());

    // error = this.isCorrectGlobalMove(error, removedCoordinates, coordinates);
    if (error == null)
      this.turn.change();
    else
      this.set(gameMemento);

    return error;
  }

  private Piece getInitialPiece(Coordinate coordinate) {
    Color color = ColorFactory.getInitialColor(coordinate);
    if (!color.isNull())
      return new Pawn(color);
    return null;
  }

  private Error isCorrectPairMove(int pair, Coordinate... coordinates) {
    assert coordinates[pair] != null;
    assert coordinates[pair + 1] != null;
    if (board.isEmpty(coordinates[pair]))
      return Error.EMPTY_ORIGIN;
    if (this.turn.getOppositeColor() == this.board.getColor(coordinates[pair]))
      return Error.OPPOSITE_PIECE;
    if (!this.board.isEmpty(coordinates[pair + 1]))
      return Error.NOT_EMPTY_TARGET;
    List<Piece> betweenDiagonalPieces =
        this.board.getBetweenDiagonalPieces(coordinates[pair], coordinates[pair + 1]);
    return this.board.getPiece(coordinates[pair]).isCorrectMovement(betweenDiagonalPieces, pair,
        coordinates);
  }

  private void pairMove(List<Coordinate> removedCoordinates, List<Piece> removedPieces, int pair,
      Coordinate... coordinates) {
    Coordinate forRemoving = this.getBetweenDiagonalPiece(pair, coordinates);
    if (forRemoving != null) {
      Piece forRemovingPiece = this.getPiece(forRemoving).copy();
      removedCoordinates.add(0, forRemoving);
      removedPieces.add(0, forRemovingPiece);
      this.board.remove(forRemoving);
    }
    this.board.move(coordinates[pair], coordinates[pair + 1]);
    if (this.board.getPiece(coordinates[pair + 1]).isLimit(coordinates[pair + 1])) {
      Color color = this.board.getColor(coordinates[pair + 1]);
      this.board.remove(coordinates[pair + 1]);
      this.board.put(coordinates[pair + 1], new Draught(color));
    }
  }

  private Coordinate getBetweenDiagonalPiece(int pair, Coordinate... coordinates) {
    assert coordinates[pair].isOnDiagonal(coordinates[pair + 1]);
    List<Coordinate> betweenCoordinates =
        coordinates[pair].getBetweenDiagonalCoordinates(coordinates[pair + 1]);
    if (betweenCoordinates.isEmpty())
      return null;
    for (Coordinate coordinate : betweenCoordinates) {
      if (this.getPiece(coordinate) != null)
        return coordinate;
    }
    return null;
  }

  /* private Error isCorrectGlobalMove(Error error, List<Coordinate> removedCoordinates,
      Coordinate... coordinates) {
    if (error != null)
      return error;
    if (coordinates.length > 2 && coordinates.length > removedCoordinates.size() + 1)
      return Error.TOO_MUCH_JUMPS;
    return null;
  } */

  public boolean isBlocked() {
    for (Coordinate coordinate : this.getCoordinatesWithActualColor())
      if (!this.isBlocked(coordinate))
        return false;
    return true;
  }

  private List<Coordinate> getCoordinatesWithActualColor() {
    List<Coordinate> coordinates = new ArrayList<Coordinate>();
    for (int i = 0; i < this.getDimension(); i++) {
      for (int j = 0; j < this.getDimension(); j++) {
        Coordinate coordinate = new Coordinate(i, j);
        Piece piece = this.getPiece(coordinate);
        if (piece != null && piece.getColor() == this.getTurnColor())
          coordinates.add(coordinate);
      }
    }
    return coordinates;
  }

  private boolean isBlocked(Coordinate coordinate) {
    for (int i = 1; i <= 2; i++)
      for (Coordinate target : coordinate.getDiagonalCoordinates(i))
        if (this.isCorrectPairMove(0, coordinate, target) == null)
          return false;
    return true;
  }

  public void cancel() {
    for (Coordinate coordinate : this.getCoordinatesWithActualColor())
      this.board.remove(coordinate);
    this.turn.change();
  }

  public Color getColor(Coordinate coordinate) {
    assert coordinate != null;
    return this.board.getColor(coordinate);
  }

  public PaletteColor getTurnColor() {
    return this.turn.getColor();
  }

  public Piece getPiece(Coordinate coordinate) {
    assert coordinate != null;
    return this.board.getPiece(coordinate);
  }

  public int getDimension() {
    return Coordinate.getDimension();
  }

  public GameMemento createMemento() {
    GameMemento memento = new GameMemento();
    memento.set(this.board.copy());

    return memento;
  }

  public void set(GameMemento gameMemento) {
    this.board = gameMemento.getBoard();
  }

  @Override
  public String toString() {
    return this.board + "\n" + this.turn;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((board == null) ? 0 : board.hashCode());
    result = prime * result + ((turn == null) ? 0 : turn.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Game other = (Game) obj;
    if (board == null) {
      if (other.board != null)
        return false;
    } else if (!board.equals(other.board))
      return false;
    if (turn == null) {
      if (other.turn != null)
        return false;
    } else if (!turn.equals(other.turn))
      return false;
    return true;
  }

}
