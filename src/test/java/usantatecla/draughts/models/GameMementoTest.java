package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameMementoTest {

  @Test
  public void testGivenGameMementoThenIsEqualToOriginalBoard() {
    Turn turn = new Turn();
    Board board = new Board();
    GameMemento gameMemento = new GameMemento(turn, board);
    assertEquals(board, gameMemento.getBoard());

  }

  @Test
  public void testGivenGameMementoThenIsEqualToOriginalTurn() {
    Turn turn = new Turn();
    Board board = new Board();
    GameMemento gameMemento = new GameMemento(turn, board);

    assertEquals(turn, gameMemento.getTurn());
  }

  @Test
  public void testGivenGameMementoWithTurnChangedThenIsEqualToOriginalTurn() {
    Turn turn = new Turn();
    turn.change();
    Board board = new Board();
    GameMemento gameMemento = new GameMemento(turn, board);

    assertEquals(turn, gameMemento.getTurn());
  }


}
