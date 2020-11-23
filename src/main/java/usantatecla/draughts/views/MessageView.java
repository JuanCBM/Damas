package usantatecla.draughts.views;

public class MessageView extends SubView {

  String message;

  public MessageView(String message) {
    this.message = message;
  }

  public void write() {
    this.console.write(this.message);
  }

  public void writeln() {
    this.console.writeln(this.message);
  }

}
