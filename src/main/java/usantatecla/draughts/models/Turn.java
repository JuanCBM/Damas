package usantatecla.draughts.models;

class Turn {

  private Color paletteColor;

  Turn() {
    this.paletteColor = Color.WHITE;
  }

  void change() {
    this.paletteColor = this.getOppositeColor();
  }

  Color getColor() {
    return this.paletteColor;
  }

  Color getOppositeColor() {
    return Color.values()[(this.paletteColor.ordinal() + 1) % 2];
  }

  @Override
  public String toString() {
    return this.paletteColor.name();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((paletteColor == null) ? 0 : paletteColor.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Turn other = (Turn) obj;
    if (paletteColor != other.paletteColor)
      return false;
    return true;
  }

  public Turn copy() {
    Turn turn = new Turn();
    if (this.getColor().equals(Color.WHITE)) {
      return turn;
    } else {
      turn.change();
      return turn;
    }
  }

}
