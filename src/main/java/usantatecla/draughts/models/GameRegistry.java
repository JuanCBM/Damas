package usantatecla.draughts.models;

import java.util.List;

public class GameRegistry {
  private Game game;


  public GameRegistry(Game game) {
    this.game = game;
  }

  public void register() {
    // TODO Auto-generated method stub
  }

  public Game getGame() {
    return this.game;
  }

  public List<GameMemento> getMementos() {
    // TODO Auto-generated method stub
    return null;
  }

}
