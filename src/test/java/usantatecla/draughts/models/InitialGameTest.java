package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class InitialGameTest {
  GameBuilder gameBuilder;

  @Before
  public void prepareGameBuilder() {
    this.gameBuilder = new GameBuilder();
  }

  @Test
  public void testWhenCreateGameThenIsInitialGame() {
    Game game = this.gameBuilder.rows(GameBuilder.INITIAL_BOARD).color(Color.WHITE).build();
    assertEquals(game, new Game());
  }

  @Test
  public void testGivenEmptyBoardWhenCreateGameThenEmptyBoard() {
    //@formatter:off
    Game game = this.gameBuilder.rows("        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ",
                                      "        ")
                                .build();
    //@formatter:on

    assertEquals(game, new Game(new Board()));
  }

  @Test
  public void testGivenGameWhenStartThenIsWhiteTurn() {
    assertEquals(new Game().getTurnColor(), Color.WHITE);
  }

  @Test
  public void testGivenBoardWhenResetThenIsReseted() {
    //@formatter:off
    Game gameFinished = this.gameBuilder.rows("        ",
                                              "        ",
                                              "        ",
                                              "        ",
                                              "        ",
                                              "        ",
                                              "        ",
                                              "B       ")
                                          .color(Color.BLACK)
                                          .build();
    //@formatter:on

    gameFinished.reset();

    assertEquals(gameFinished, new Game());

  }
}
