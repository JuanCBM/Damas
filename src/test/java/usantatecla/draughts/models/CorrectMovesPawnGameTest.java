package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Test;

public class CorrectMovesPawnGameTest {

  @Test
  public void testGivenGameWhenMoveThenPawntIsMoved() {
    fail("Not yet implemented");
  }

  @Test
  public void testGameBoard() {
    Game game = this.gameBuilder.rows("n       ", "        ", "        ", "        ", "        ",
        "        ", "        ", "b       ").build();

    Coordinate origin = new Coordinate(7, 0);
    Coordinate target = new Coordinate(6, 1);

    game.move(origin, target);

    assertEquals(game.getPiece(origin), null);
    assertNotNull(game.getPiece(target));



  }

  @Test
  public void test() {
    Game game = new Game();
    Coordinate origin = new Coordinate(5, 0);
    Coordinate target = new Coordinate(4, 1);
    game.move(origin, target);

    System.out.print(game);
    assertNull(game.getColor(origin));
    assertEquals(Color.WHITE, game.getColor(target));
    origin = new Coordinate(2, 3);
    target = new Coordinate(3, 4);
    game.move(origin, target);
    assertNull(game.getColor(origin));
    assertEquals(Color.BLACK, game.getColor(target));
  }


  // Test de convertirse en reina
  // Test de comer 1.
  // Test de comer varios.
  // Test de gana
  // test de empata


}
