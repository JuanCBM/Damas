package usantatecla.draughts.utils;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {

  private static final String OPTION = "Option? [1-#size]: ";
  private List<Command> commandList;
  private Console console;

  public Menu() {
    this.commandList = new ArrayList<Command>();
    this.console = new Console();
  }

  public void execute() {
    ArrayList<Command> commands = new ArrayList<Command>();
    for (int i = 0; i < this.commandList.size(); i++) {
      if (this.commandList.get(i).isActive()) {
        commands.add(this.commandList.get(i));
      }
    }
    int option;
    boolean error;
    do {
      error = false;
      this.console.writeln();
      for (int i = 0; i < commands.size(); i++) {
        this.console.writeln((i + 1) + ") " + commands.get(i).getTitle());
      }
      option = this.console.readInt(Menu.OPTION.replace("#size", "" + commands.size())) - 1;
      if (!new ClosedInterval(0, commands.size() - 1).isIncluded(option)) {
        error = true;
      }
    } while (error);
    commands.get(option).execute();
  }

  protected void addCommand(Command command) {
    this.commandList.add(command);
  }

}
