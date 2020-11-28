package usantatecla.draughts.models;

public class Session {

  private Game game;
  private GameRegistry registry;
  private State state;

  public Session() {
    this.state = new State();
    this.game = new Game();
    this.registry = new GameRegistry(this.game);
  }

  public void undo() {
    this.registry.undo();
  }

  public void redo() {
    this.registry.redo();
  }

  public Piece getPiece(Coordinate coordinate) {
    return this.game.getPiece(coordinate);
  }

  public void reset() {
    this.state.reset();
    this.game.reset();
  }

  public boolean isBlocked() {
    return this.game.isBlocked();
  }

  public Error move(Coordinate[] coordinates) {
    return this.game.move(coordinates);
  }

  public void cancel() {
    this.game.cancel();
    this.state.reset();
  }

  public void next() {
    this.state.next();
  }

  public Color getTurnColor() {
    return this.game.getTurnColor();
  }

  public StateValue getValueState() {
    return this.state.getValueState();
  }

  public int getDimension() {
    return this.game.getDimension();
  }

  public Color getColor(Coordinate coordinate) {
    return this.game.getColor(coordinate);
  }

  public boolean undoable() {
    return this.registry.isUndoable();
  }

}
