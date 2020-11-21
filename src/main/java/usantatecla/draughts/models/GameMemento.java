package usantatecla.draughts.models;

public class GameMemento {

  private Board board;

  public void set(Board board) {
    this.board = board;
  }

  public Board getBoard() {
    return this.board;
  }

}
