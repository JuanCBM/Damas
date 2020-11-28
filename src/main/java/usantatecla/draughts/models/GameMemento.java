package usantatecla.draughts.models;

public class GameMemento {

  private Turn turn;
  private Board board;

  public GameMemento(Turn turn, Board board) {
    this.board = board.copy();
    this.turn = turn.copy();
  }

  public Board getBoard() {
    return this.board;
  }

  public Turn getTurn() {
    return this.turn;
  }

}
