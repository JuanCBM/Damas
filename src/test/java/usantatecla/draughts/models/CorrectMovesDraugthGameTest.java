package usantatecla.draughts.models;

import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

// @formatter:off
public class CorrectMovesDraugthGameTest {
  
  GameBuilder gameBuilder;

  @Before
  public void prepareGameBuilder() {
    this.gameBuilder = new GameBuilder();
  }
  
  @Test
  public void testGivenGameWhenMoveThenDraughtIsMoved() {
    Game game =  this.gameBuilder.rows( " n      ",
                                        "        ",
                                        "        ",
                                        "        ",
                                        "        ",
                                        "        ",
                                        "        ",
                                        "b       ").build();
    Coordinate origin = new Coordinate(2, 1);
    Coordinate target = new Coordinate(3, 2);
    
    game.move(origin, target);
    
    fail("Not yet implemented");
  }

  // Test de mover reina varias casillas
  // Test de mover reina una casilla
  // Test de comer 1.
  // Test de comer varios.
  // Test de gana
  // test de empata


}
