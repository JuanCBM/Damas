package usantatecla.draughts.views;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Error;
import usantatecla.draughts.utils.Console;

public class PlayCommand extends Command {

  private Console console;
  private static final String COLOR_PARAM = "#color";
  private static final String[] COLOR_VALUES = {"blancas", "negras"};
  private static final String PROMPT = "Mueven las " + COLOR_PARAM + ": ";
  private static final String CANCEL_FORMAT = "-1";
  private static final String MOVEMENT_FORMAT = "[1-8]{2}(\\.[1-8]{2}){1,2}";
  private static final String ERROR_MESSAGE = "Error!!! Formato incorrecto";
  private static final String LOST_MESSAGE = "Derrota!!! No puedes mover tus fichas!!!";
  private String string;

  PlayCommand(PlayController playController) {
    super(Message.ACTION_COMMAND.getMessage(), playController);
    this.console = new Console();
  }

  @Override
  public void execute() {
    assert playController != null;
    Error error;
    this.console.writeln();
    new GameView().write(playController);

    do {
      error = null;
      this.string = this.read(playController.getColor());
      if (this.isCanceledFormat())
        playController.cancel();
      else if (!this.isMoveFormat()) {
        error = Error.BAD_FORMAT;
        this.writeError();
      } else {
        error = playController.move(this.getCoordinates());
        new GameView().write(playController);
        if (error == null && playController.isBlocked())
          this.writeLost();
      }
    } while (error != null);

  }

  private String read(Color paletteColor) {
    final String titleColor = PROMPT.replace(COLOR_PARAM, COLOR_VALUES[paletteColor.ordinal()]);
    return this.console.readString(titleColor);
  }

  private boolean isCanceledFormat() {
    return string.equals(CANCEL_FORMAT);
  }

  private boolean isMoveFormat() {
    return Pattern.compile(MOVEMENT_FORMAT).matcher(string).find();
  }

  private void writeError() {
    this.console.writeln(ERROR_MESSAGE);
  }

  private Coordinate[] getCoordinates() {
    assert this.isMoveFormat();
    List<Coordinate> coordinateList = new ArrayList<Coordinate>();
    while (string.length() > 0) {
      coordinateList.add(Coordinate.getInstance(string.substring(0, 2)));
      string = string.substring(2, string.length());
      if (string.length() > 0 && string.charAt(0) == '.')
        string = string.substring(1, string.length());
    }
    Coordinate[] coordinates = new Coordinate[coordinateList.size()];
    for (int i = 0; i < coordinates.length; i++) {
      coordinates[i] = coordinateList.get(i);
    }
    return coordinates;
  }

  private void writeLost() {
    this.console.writeln(LOST_MESSAGE);
  }

  @Override
  public boolean isActive() {
    return true;
  }

}
