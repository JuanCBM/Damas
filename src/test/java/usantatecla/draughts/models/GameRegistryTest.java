package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class GameRegistryTest {

  Game game;

  @Before
  public void before() {
    this.game = game(GameBuilder.INITIAL_BOARD);
  }

  private static Game game(String... rows) {
    return new GameBuilder().rows(rows).build();
  }

  @Test
  public void testGivenGameRegistryWhenCreateThenIsCorrect() {
    GameRegistry registry = new GameRegistry(this.game);
    assertEquals(this.game, registry.getGame());
  }

  @Test
  public void testGivenGameRegistryWhenRegistryThenIsCorrect() {
    List<GameMemento> mementos = new ArrayList<>();
    GameMemento gameMemento = new GameMemento(new Turn(), this.game.getBoard());
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

    GameRegistry registry = new GameRegistry(this.game);
    this.game.getBoard().move(new Coordinate(5, 0), new Coordinate(4, 1));
    registry.register();

    for (int i = 0; i < mementos.size(); i++) {
      assertEquals(mementos.get(i).getBoard(), registry.getMementos().get(i).getBoard());
    }

  }

  @Test
  public void testGivenGameRegistryWhenUndoThenIsCorrect() {

    GameMemento gameMemento = new GameMemento(new Turn(), this.game.getBoard());

    GameRegistry registry = new GameRegistry(this.game);
    this.game.getBoard().move(new Coordinate(5, 0), new Coordinate(4, 1));

    registry.register();
    registry.undo();

    assertEquals(gameMemento.getBoard(), registry.getGame().getBoard());

  }

  @Test
  public void testGivenGameRegistryWhenRedoThenIsCorrect() {

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

    GameMemento gameMemento = new GameMemento(new Turn(), gameAfterMove.getBoard());

    GameRegistry registry = new GameRegistry(this.game);
    this.game.getBoard().move(new Coordinate(5, 0), new Coordinate(4, 1));

    registry.register();
    registry.undo();
    registry.redo();

    assertEquals(gameMemento.getBoard(), registry.getGame().getBoard());

  }

}
