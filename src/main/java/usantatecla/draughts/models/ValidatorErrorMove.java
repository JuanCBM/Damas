package usantatecla.draughts.models;

public class ValidatorErrorMove {

    private Board board;
    private Turn turn;
    private Coordinate origin;
    private Coordinate target;

    ValidatorErrorMove(Board board, Turn turn, Coordinate origin, Coordinate target) {
        this.board = board;
        this.turn = turn;
        this.origin = origin;
        this.target = target;
    }

    Error checkError() {
        return this.checkIsEmptyOrigin();
    }

    private Error checkIsEmptyOrigin() {
        if (this.board.isEmpty(this.origin)) {
            return Error.EMPTY_ORIGIN;
        }
        return this.checkIsValidTurn();
    }

    private Error checkIsValidTurn() {
        Color color = this.board.getColor(this.origin);
        if (this.turn.getColor() != color) {
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
        return null;
    }
}
