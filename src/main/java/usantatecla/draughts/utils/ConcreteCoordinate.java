package usantatecla.draughts.utils;

public class ConcreteCoordinate implements Coordinate {

  protected int row;
  protected int column;
  static final String ROW = "Row: ";
  static final String COLUMN = "Column: ";

  protected ConcreteCoordinate() {}

  protected ConcreteCoordinate(int row, int column) {
    this.row = row;
    this.column = column;
  }

  @Override
  public boolean isNull() {
    return false;
  }

  @Override
  public Direction getDirection(Coordinate coordinate) {
    if (this.inHorizontal(coordinate)) {
      return Direction.HORIZONTAL;
    }
    if (this.inVertical(coordinate)) {
      return Direction.VERTICAL;
    }
    if (this.inMainDiagonal() && coordinate.inMainDiagonal()) {
      return Direction.MAIN_DIAGONAL;
    }
    return Direction.NULL;
  }

  @Override
  public boolean inHorizontal(Coordinate coordinate) {
    if (coordinate.isNull()) {
      return false;
    }
    return this.row == ((ConcreteCoordinate) coordinate).row;
  }

  @Override
  public boolean inVertical(Coordinate coordinate) {
    if (coordinate.isNull()) {
      return false;
    }
    return this.column == ((ConcreteCoordinate) coordinate).column;
  }

  @Override
  public boolean inMainDiagonal() {
    return this.row - this.column == 0;
  }

  public int getRow() {
    return this.row;
  }

  public int getColumn() {
    return this.column;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    ConcreteCoordinate other = (ConcreteCoordinate) obj;
    if (this.column != other.column) {
      return false;
    }
    if (this.row != other.row) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Coordinate [row=" + this.row + ", column=" + this.column + "]";
  }

}
