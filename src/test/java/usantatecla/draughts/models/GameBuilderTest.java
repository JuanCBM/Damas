package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

// TODO: Add asserts to GameBuilder to control next situations:
//@formatter:off
public class GameBuilderTest {

  GameBuilder gameBuilder;

  @Before
  public void prepareGameBuilder() {
    this.gameBuilder = new GameBuilder();
  }
  
  @Test(expected = AssertionError.class)
  public void testGivenGameBuilderWhenIncorrectRowsLengthThenError() {
    this.gameBuilder.rows("n       ",
                          "        ",
                          "        ",
                          "        ",
                          "        ",
                          "        ",
                          "        ",
                          "b        ").build();
  }
  
  @Test(expected = AssertionError.class)
  public void testGivenGameBuilderWhenIncorrectPieceThenError() {
    this.gameBuilder.rows("        ",
                          "        ",
                          "        ",
                          "        ",
                          "    r   ",
                          "        ",
                          "        ",
                          "        ").build();
  }

  @Test(expected = AssertionError.class)
  public void testGivenGameBuilderWhenEmptyRowshenError() {
    this.gameBuilder.rows("        ",
                          "        ",
                          "        ",
                          "        ",
                          "        ",
                          "        ",
                          "        ",
                          "        ").build();
  }

  @Test()
  public void testGivenGameBuilderWhenEmptyRowsNo() {
    Game game = this.gameBuilder.rows("        ",
                          "        ",
                          "        ",
                          "        ",
                          "        ",
                          "        ",
                          "        ",
                          "        ")
    .color(Color.BLACK).build();
    System.out.print(game);
  }
  
}
