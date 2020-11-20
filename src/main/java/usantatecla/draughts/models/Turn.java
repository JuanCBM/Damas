package usantatecla.draughts.models;

class Turn {

  private PaletteColor color;

  Turn() {
    this.color = PaletteColor.WHITE;
  }

  void change() {
    this.color = this.getOppositeColor();
  }

  PaletteColor getColor() {
    return this.color;
  }

  PaletteColor getOppositeColor() {
    return PaletteColor.values()[(this.color.ordinal() + 1) % 2];
  }

  @Override
  public String toString() {
    return this.color.name();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((color == null) ? 0 : color.hashCode());
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
    if (color != other.color)
      return false;
    return true;
  }

}