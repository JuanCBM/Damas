package usantatecla.draughts.models;

import org.junit.Before;

class GameBuilderUser {
  GameBuilder gameBuilder;

  @Before
  public void prepareGameBuilder() {
    this.gameBuilder = new GameBuilder();
  }
}
