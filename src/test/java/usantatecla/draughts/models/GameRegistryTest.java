package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameRegistryTest {

  Game game;

  private static Game game(String... rows) {


    return new GameBuilder().rows(rows).build();

  }

  @Test
  public void testGivenGameRegistryWhenRegistryThenIsCorrect() {
    // @formatter:off
    Game game = game(
        "        ",
        "        ",
        " n   n  ",
        "  n n   ",
        "   b    ",
        "        ",
        "        ",
        "        ");
    // @formatter:on
    GameRegistry registry = new GameRegistry(game);
    registry.register();

    assertEquals(game, registry.getGame());


  }



}
