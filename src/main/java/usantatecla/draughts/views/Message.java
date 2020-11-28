package usantatecla.draughts.views;

public enum Message {

  ACTION_COMMAND("Do a action"), UNDO_COMMAND("Undo previous action"), REDO_COMMAND(
      "Redo previous action"), RESUME("Do you want to continue");

  private String message;

  private Message(String message) {
    this.message = message;
  }

  public String getMessage() {
    return this.message;
  }

}
