package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;

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
  this.pieceBuilder.color(null).build();
  }

  @Test
  public void testGivenPieceBuilderWhenNullTypeThenNullPiece() {
    assertEquals(null,this.pieceBuilder.piece(null).build());
  }

  @Test
  public void testGivenPieceBuilderWhenPawnTypeThenOK() {
    assertEquals(new Pawn(Color.WHITE),this.pieceBuilder.piece("p").build());
  }

  @Test
  public void testGivenPieceBuilderWhenDraughtTypeThenOK() {
    assertEquals(new Draught(Color.WHITE),this.pieceBuilder.piece("d").build());
  }

  @Test
  public void testGivenPieceBuilderWhenWhiteColorThenOK() {
    assertEquals(Color.WHITE,this.pieceBuilder.color(Color.WHITE).build().getColor());
  }

  @Test
  public void testGivenPieceBuilderWhenBlackColorThenOK() {
    assertEquals(Color.BLACK,this.pieceBuilder.color(Color.BLACK).build().getColor());
  }
  }
