package usantatecla.draughts.views;

public class ConsoleView extends SubView {

  public void write(String message) {
    this.console.write(message);
  }

  public void writeln(String message) {
    this.console.writeln(message);
  }

  public void writeln() {
    this.console.writeln();
  }

  public String read(String message) {
    return this.console.readString(message);
  }

}
