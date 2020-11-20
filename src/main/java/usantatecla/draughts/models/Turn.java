package usantatecla.draughts.models;

class Turn {

  private ColorPalette colorPalette;

  Turn() {
    this.colorPalette = ColorPalette.WHITE;
  }

  void change() {
    this.colorPalette = this.getOppositeColor();
  }

  ColorPalette getColor() {
    return this.colorPalette;
  }

  ColorPalette getOppositeColor() {
    return ColorPalette.values()[(this.colorPalette.ordinal() + 1) % 2];
  }

  @Override
  public String toString() {
    return this.colorPalette.name();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((colorPalette == null) ? 0 : colorPalette.hashCode());
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
    if (colorPalette != other.colorPalette)
      return false;
    return true;
  }

}