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
    if (this.turn.getColor() != Color.WHITE)
      this.turn.change();
  }

  public Error move(Coordinate... coordinates) {
    Error error = null;
    List<Coordinate> removedCoordinates = new ArrayList<Coordinate>();
    int pair = 0;

    GameMemento gameMemento = this.createMemento();

    ValidatorErrorMove validatorErrorMove = null;
    do {
      Coordinate origin = coordinates[pair];
      Coordinate target = coordinates[pair + 1];

      validatorErrorMove = new ValidatorErrorMove(this.board, this.turn, pair, coordinates);
      error = validatorErrorMove.checkError();
      if (error == null) {
        this.pairMove(removedCoordinates, origin, target);
        pair++;
      }
    } while (pair < coordinates.length - 1 && error == null);

    validatorErrorMove.setRemovedSizeAndError(removedCoordinates.size(), error);
    error = validatorErrorMove.checkGlobalError();

    if (error == null)
      this.turn.change();
    else
      this.set(gameMemento);

    return error;
  }

  private Piece getInitialPiece(Coordinate coordinate) {
    Color color = Color.getInitialColor(coordinate);
    if (!color.isNull())
      return new Pawn(color);
    return null;
  }

  private void pairMove(List<Coordinate> removedCoordinates, Coordinate origin, Coordinate target) {
    Coordinate forRemoving = this.getBetweenDiagonalPiece(origin, target);
    if (forRemoving != null) {
      removedCoordinates.add(0, forRemoving);
      this.board.remove(forRemoving);
    }

    this.board.move(origin, target);
    if (this.board.getPiece(target).isLimit(target)) {
      Color color = this.board.getColor(target);
      this.board.remove(target);
      this.board.put(target, new Draught(color));
    }
  }

  private Coordinate getBetweenDiagonalPiece(Coordinate origin, Coordinate target) {
    assert origin.isOnDiagonal(target);
    List<Coordinate> betweenCoordinates = origin.getBetweenDiagonalCoordinates(target);
    if (betweenCoordinates.isEmpty())
      return null;
    for (Coordinate coordinate : betweenCoordinates) {
      if (this.getPiece(coordinate) != null)
        return coordinate;
    }
    return null;
  }

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
      for (Coordinate target : coordinate.getDiagonalCoordinates(i)) {
        Coordinate coordinates[] = {coordinate, target};
        ValidatorErrorMove errorMove =
            new ValidatorErrorMove(this.board, this.turn, 0, coordinates);
        if (errorMove.checkError() == null)
          return false;
      }
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

  public Color getTurnColor() {
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
    return new GameMemento(turn, board);
  }

  public void set(GameMemento gameMemento) {
    this.board = gameMemento.getBoard();
    this.turn = gameMemento.getTurn();
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

  public Board getBoard() {
    return this.board;
  }

}
