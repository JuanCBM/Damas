package usantatecla.draughts.views;

import usantatecla.draughts.utils.Console;

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

  public void write() {
    new Console().write(this.message);
  }

  public void writeln() {
    new Console().writeln(this.message);
  }

  @Override
  public String toString() {
    return this.message;
  }

}
