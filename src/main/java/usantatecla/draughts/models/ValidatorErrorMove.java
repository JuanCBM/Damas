package usantatecla.draughts.models;

import java.util.List;

public class ValidatorErrorMove {

    private Board board;
    private Turn turn;
    private Coordinate origin;
    private Coordinate target;
    private int pair;
    private Coordinate[] coordinates;
    private int removedCoordinatesSize;

    ValidatorErrorMove(Board board, Turn turn, int pair, Coordinate... coordinates) {
        this.board = board;
        this.turn = turn;
        this.origin = coordinates[pair];
        this.target = coordinates[pair + 1];
        this.pair = pair;
        this.coordinates = coordinates;
    }

    public void setRemovedSize(int size) {
        this.removedCoordinatesSize = size;
    }

    Error checkError() {
        return this.checkIsEmptyOrigin();
    }

    Error checkGlobalError(Error error) {
        if (error == null)
            return this.checkIsTooMuchJumps();
        return error;
    }

    private Error checkIsTooMuchJumps() {
        if (coordinates.length > 2 && coordinates.length > this.removedCoordinatesSize + 1)
            return Error.TOO_MUCH_JUMPS;
        return null;
    }

    private Error checkIsEmptyOrigin() {
        if (this.board.isEmpty(this.origin)) {
            return Error.EMPTY_ORIGIN;
        }
        return this.checkIsValidTurn();
    }

    private Error checkIsValidTurn() {
        Color color = this.board.getColor(this.origin);
        if (this.turn.getOppositeColor() != color) {
            return Error.OPPOSITE_PIECE;
        }
        return this.checkIsDiagonalMove();
    }

    private Error checkIsDiagonalMove() {
        if (!this.origin.isOnDiagonal(this.target)) {
            return Error.NOT_DIAGONAL;
        }
        return this.checkIsAdvancedMove();
    }

    private Error checkIsAdvancedMove() {
        Piece piece = this.board.getPiece(this.origin);
        if (!piece.isAdvanced(this.origin, this.target)) {
            return Error.NOT_ADVANCED;
        }
        return this.checkIsEmptyTarget();
    }

    private Error checkIsEmptyTarget() {
        if (!this.board.isEmpty(this.target)) {
            return Error.NOT_EMPTY_TARGET;
        }
        List<Piece> betweenDiagonalPieces = this.board.getBetweenDiagonalPieces(this.origin, this.target);
        return this.board.getPiece(this.origin).isCorrectMovement(betweenDiagonalPieces, this.pair, this.coordinates);
    }
}
