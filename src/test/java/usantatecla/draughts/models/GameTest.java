package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

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

  @Test
  public void testGivenGameWhenGameCancelThenOk() {
    Game game = this.gameBuilder.rows(GameBuilder.INITIAL_BOARD).build();
    game.cancel();
    for (int i = 0; i < Coordinate.getDimension(); i++) {
      for (int j = 0; j < Coordinate.getDimension(); j++) {
        Coordinate coordinate = new Coordinate(i, j);
        if (game.getPiece(coordinate) != null) {
          assertNotEquals(game.getPiece(coordinate).getColor(), Color.WHITE);
        }
      }
    }
  }

  @Test
  public void testGivenCoordinateWhenGetColorThenWhite() {
    Game game = this.gameBuilder.rows(GameBuilder.INITIAL_BOARD).build();
    assertEquals(game.getColor(new Coordinate(7, 0)), Color.WHITE);
  }

  @Test
  public void testGivenCoordinateWhenGetColorThenBlack() {
    Game game = this.gameBuilder.rows(GameBuilder.INITIAL_BOARD).build();
    assertEquals(game.getColor(new Coordinate(0, 1)), Color.BLACK);
  }

  @Test
  public void testGivenGameWhenGetPieceThenIsWhite() {
    Game game = this.gameBuilder.rows(GameBuilder.INITIAL_BOARD).build();
    assertEquals(game.getPiece(new Coordinate(7, 0)), new Pawn(Color.WHITE));
  }

  @Test
  public void testGivenGameWhenGetPieceThenIsBlack() {
    Game game = this.gameBuilder.rows(GameBuilder.INITIAL_BOARD).build();
    assertEquals(game.getPiece(new Coordinate(0, 1)), new Pawn(Color.BLACK));
  }

  @Test
  public void testGivenGameWhenGetPieceThenIsEmpty() {
    Game game = this.gameBuilder.rows(GameBuilder.INITIAL_BOARD).build();
    assertNull(game.getPiece(new Coordinate(3, 3)));
  }

  @Test
  public void testGivenGameWhenGetDimentionThenIsEigth() {
    Game game = this.gameBuilder.rows(GameBuilder.INITIAL_BOARD).build();
    assertEquals(game.getDimension(), 8);
  }

}
