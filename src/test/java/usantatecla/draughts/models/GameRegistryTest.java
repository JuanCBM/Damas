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
    Game game = game(GameBuilder.INITIAL_BOARD);

    List<GameMemento> mementos = new ArrayList<>();
    GameMemento gameMemento = new GameMemento(new Turn(), game.getBoard());
    mementos.add(gameMemento);

    // @formatter:off
    Game gameAfterMove = game(  " n n n n",
                                "n n n n ", 
                                " n n n n", 
                                "        ", 
                                " b      ",
                                "  b b b ", 
                                " b b b b", 
                                "b b b b ");
    // @formatter:on

    GameMemento gameMementoAfterMove = new GameMemento(new Turn(), gameAfterMove.getBoard());
    mementos.add(0, gameMementoAfterMove);

    GameRegistry registry = new GameRegistry(game);
    game.getBoard().move(new Coordinate(5, 0), new Coordinate(4, 1));
    registry.register();

    for (int i = 0; i < mementos.size(); i++) {
      assertEquals(mementos.get(i).getBoard(), registry.getMementos().get(i).getBoard());
    }

  }


}
