package usantatecla.draughts.models;

public enum PaletteColor {
    WHITE,
    BLACK;

    private final int[] LIMITS = new int[]{5, 2};

    boolean isInitialRow(final int row){
        switch(this){
            case WHITE:
                return row >= LIMITS[this.ordinal()];
            case BLACK:
                return row <= LIMITS[this.ordinal()];
        }
        return false;
    }

    static PaletteColor getInitialColor(final Coordinate coordinate) {
        if (coordinate.isBlack())
            for(PaletteColor color : PaletteColor.values())
                if (color.isInitialRow(coordinate.getRow()))
                    return color;
        return null;
    }
	
}