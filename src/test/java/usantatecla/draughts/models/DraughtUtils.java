package usantatecla.draughts.models;

import java.util.HashMap;
import java.util.Map;

public class DraughtUtils {
  protected static final Map<Character, Piece> piecesMap = new HashMap<Character, Piece>() {
    protected static final long serialVersionUID = 1L;
    {
      put('b', new Pawn(Color.WHITE));
      put('B', new Draught(Color.WHITE));
      put('n', new Pawn(Color.BLACK));
      put('N', new Draught(Color.BLACK));
    }
  };

}
