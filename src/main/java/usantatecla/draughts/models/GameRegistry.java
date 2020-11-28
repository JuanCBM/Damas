package usantatecla.draughts.models;

import java.util.ArrayList;
import java.util.List;

public class GameRegistry {
  private Game game;
  private List<GameMemento> mementos;
  private int firstPrevious;

  public GameRegistry(Game game) {
    this.game = game;
    this.mementos = new ArrayList<GameMemento>();
    this.firstPrevious = 0;
    this.mementos.add(this.firstPrevious, this.game.createMemento());
  }

  public void register() {
    for (int i = 0; i < this.firstPrevious; i++) {
      this.mementos.remove(0);
      this.firstPrevious--;
    }
    this.mementos.add(this.firstPrevious, this.game.createMemento());
  }

  public List<GameMemento> getMementos() {
    return this.mementos;
  }

  public Game getGame() {
    return this.game;
  }

  public void undo() {
    this.firstPrevious++;
    this.game.set(this.mementos.get(this.firstPrevious));
  }

  void redo() {
    this.firstPrevious--;
    this.game.set(this.mementos.get(this.firstPrevious));
  }

}
