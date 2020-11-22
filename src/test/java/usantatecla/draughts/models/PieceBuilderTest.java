package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;
import org.javatuples.Triplet;
import org.junit.Before;
import org.junit.Test;

public class PieceBuilderTest {

  PieceBuilder pieceBuilder;

  @Before
  public void prepareGameBuilder() {
    this.pieceBuilder = new PieceBuilder();
  }

  @Test(expected = AssertionError.class)
  public void testGivenPieceBuilderWhenNullColorThenError() {
    this.pieceBuilder.piece(null).build();
  }

  @Test
  public void testGivenPieceBuilderWhenThenOK() {
    // @formatter:off
    List<Triplet<Character, Color, Class<?>>> characterColorClass = Arrays.asList(
        new Triplet<>('N', Color.BLACK, Draught.class), 
        new Triplet<>('n', Color.BLACK, Pawn.class),
        new Triplet<>('B', Color.WHITE, Draught.class),
        new Triplet<>('b', Color.WHITE, Pawn.class));    
    // @formatter:on

    for (Triplet<Character, Color, Class<?>> triplet : characterColorClass) {
      Piece piece = this.pieceBuilder.piece(triplet.getValue0()).build();

      assertEquals(triplet.getValue1(), piece.getColor());
      assertEquals(triplet.getValue2(), piece.getClass());

    }

  }

}
