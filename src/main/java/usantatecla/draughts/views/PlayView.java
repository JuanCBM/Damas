package usantatecla.draughts.views;

public class PlayView extends SubView {

  public PlayView() {
    super();
  }

  public String read(String movementMessage) {
    return this.console.readString(movementMessage);
  }

}
