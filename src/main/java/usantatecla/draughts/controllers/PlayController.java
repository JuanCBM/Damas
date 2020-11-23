package usantatecla.draughts.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.PaletteColor;
import usantatecla.draughts.models.State;
import usantatecla.draughts.views.GameView;
import usantatecla.draughts.views.MessageView;
import usantatecla.draughts.views.PlayView;

public class PlayController extends InteractorController {

  private static final int MINIMUM_COORDINATES = 2;
  private static final String CANCEL_FORMAT = "-1";
  private static final String MOVEMENT_FORMAT = "[1-8]{2}(\\.[1-8]{2}){1,2}";
  private static final String ERROR_MESSAGE = "Error!!! Formato incorrecto";
  private static final String LOST_MESSAGE = "Derrota!!! No puedes mover tus fichas!!!";
  private static final String TITTLE = "Draughts";

  private static final String COLOR_PARAM = "#color";
  private static final String[] COLOR_VALUES = {"blancas", "negras"};
  private static final String PROMPT = "Mueven las " + COLOR_PARAM + ": ";

  private PlayView playView;
  private String string;

  public PlayController(Game game, State state) {
    super(game, state);
    new MessageView(TITTLE).writeln();
    this.playView = new PlayView();

  }

  public Error move(Coordinate... coordinates) {
    assert coordinates.length >= MINIMUM_COORDINATES;
    for (Coordinate coordinate : coordinates)
      assert coordinate != null;
    Error error = this.game.move(coordinates);
    if (this.game.isBlocked())
      this.state.next();
    return error;
  }

  public void cancel() {
    this.game.cancel();
    this.state.next();
  }

  public PaletteColor getColor() {
    return this.game.getTurnColor();
  }

  public boolean isBlocked() {
    return this.game.isBlocked();
  }

  @Override
  public void control() {

    Error error;
    new MessageView(StringUtils.EMPTY).writeln();
    new GameView().write(this.game);

    do {
      error = null;
      this.string =
          this.playView.read(PROMPT.replace(COLOR_PARAM, COLOR_VALUES[this.getColor().ordinal()]));
      if (this.isCanceledFormat())
        this.cancel();
      else if (!this.isMoveFormat()) {
        error = Error.BAD_FORMAT;
        new MessageView(ERROR_MESSAGE).writeln();
      } else {
        error = this.move(this.getCoordinates());
        new GameView().write(this.game);
        if (error == null && this.isBlocked())
          new MessageView(LOST_MESSAGE).writeln();
      }
    } while (error != null);
  }

  public boolean isCanceledFormat() {
    return string.equals(CANCEL_FORMAT);
  }

  public boolean isMoveFormat() {
    return Pattern.compile(MOVEMENT_FORMAT).matcher(string).find();
  }

  public Coordinate[] getCoordinates() {
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


  private String readMovementFormat(PaletteColor paletteColor) {
    return PROMPT.replace(COLOR_PARAM, COLOR_VALUES[paletteColor.ordinal()]);
  }

}
