package usantatecla.draughts.models;

public class Session {

  private Game game;
  private GameRegistry registry;
  private State state;

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

  public Piece getPiece(Coordinate coordinate) {
    return this.game.getPiece(coordinate);
  }

  public void reset() {
    this.state.reset();
    this.game.reset();
  }

  public boolean isBlocked() {
    // TODO Auto-generated method stub
    return false;
  }

  public Error move(Coordinate[] coordinates) {
    // TODO Auto-generated method stub
    return null;
  }

  public void cancel() {
    // TODO Auto-generated method stub

  }

  public void next() {
    // TODO Auto-generated method stub

  }

  public Color getTurnColor() {
    // TODO Auto-generated method stub
    return null;
  }

  public Object getValueState() {
    // TODO Auto-generated method stub
    return null;
  }

  public int getDimension() {
    // TODO Auto-generated method stub
    return 0;
  }

  public Color getColor(Coordinate coordinate) {
    // TODO Auto-generated method stub
    return null;
  }

}
