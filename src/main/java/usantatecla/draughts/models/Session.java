package usantatecla.draughts.models;

public class Session {

  private Game game;
  private GameRegistry registry;

  public Session() {
    this.game = new Game();
    this.registry = new GameRegistry(this.game);
  }

  public void undo() {
    this.registry.undo();
  }

  public void redo() {
    this.registry.redo();
  }

}
