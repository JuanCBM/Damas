package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.State;
import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.Game;

public class PlayController extends InteractorController {

	private static final int MINIMUM_COORDINATES = 2;


	public PlayController(Game game, State state) {
		super(game, state);
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

	public Color getColor() {
		return this.game.getTurnColor();
	}

	public boolean isBlocked() {
		return this.game.isBlocked();
	}

	@Override
	public void accept(InteractorControllersVisitor controllersVisitor) {
		assert controllersVisitor != null;
		controllersVisitor.visit(this);
	}

}