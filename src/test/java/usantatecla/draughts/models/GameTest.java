package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

  private GameBuilder gameBuilder;

  @Before
  public void prepareGameBuilder() {
    this.gameBuilder = new GameBuilder();
  }

  @Test
  public void testCreateGame() {
    //@formatter:off
    Game game = this.gameBuilder.rows( 
        "n n n n ",
        " n n n n",
        "n n n n ",
        "        ",
        "        ",
        "b b b b ",
        " b b b b",
        "b b b b "
        ).color(Color.BLACK).build();
    //@formatter:on

    System.out.print(game.toString());
  }

}
