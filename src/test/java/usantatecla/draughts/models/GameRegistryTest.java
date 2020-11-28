package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GameRegistryTest {

  Game game;

  private static Game game(String... rows) {
    return new GameBuilder().rows(rows).build();
  }

  @Test
  public void testGivenGameRegistryWhenCreateThenIsCorrect() {
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
    assertEquals(game, registry.getGame());
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

    List<GameMemento> mementos = new ArrayList<>();
    GameMemento gameMemento = new GameMemento(new Turn(), new Board());
    mementos.add(gameMemento);

    assertEquals(mementos, registry.getMementos());


  }



}
