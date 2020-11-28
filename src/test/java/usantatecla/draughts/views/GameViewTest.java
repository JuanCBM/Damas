package usantatecla.draughts.views;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import usantatecla.draughts.controllers.UseCaseController;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Draught;
import usantatecla.draughts.models.Pawn;

@RunWith(MockitoJUnitRunner.class)
public class GameViewTest {
  private final int DIMENSION = 5;
  private final Color black = Color.BLACK;
  private final Color white = Color.WHITE;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Mock
  UseCaseController useCaseController;

  @InjectMocks
  private GameView gameView;

  @Before
  public void setUp() {
    System.setOut(new PrintStream(outContent));
  }

  @Test
  public void testWriteNumbersOfColumnsAtTop() {
    when(this.useCaseController.getDimension()).thenReturn(DIMENSION);
    this.gameView.write(useCaseController);
    assertEquals(" 12345", this.topAndBottomNumberLines().get(0));
  }

  @Test
  public void testWriteNumbersOfColumnsAtBottom() {
    when(this.useCaseController.getDimension()).thenReturn(DIMENSION);
    this.gameView.write(useCaseController);
    assertEquals(" 12345", this.topAndBottomNumberLines().get(1));
  }

  @Test
  public void testWriteFirstRowNumberAtTheBeginning() {
    when(this.useCaseController.getDimension()).thenReturn(DIMENSION);
    this.gameView.write(useCaseController);
    assertEquals("1", firstCharacterOfLine(boardLine(1)));
  }

  @Test
  public void testWriteLastRowNumberAtTheBeginning() {
    when(this.useCaseController.getDimension()).thenReturn(DIMENSION);
    this.gameView.write(useCaseController);
    assertEquals("5", firstCharacterOfLine(boardLine(DIMENSION)));

  }

  @Test
  public void testWriteFirstRowNumberAtLastOfLine() {
    when(this.useCaseController.getDimension()).thenReturn(DIMENSION);
    this.gameView.write(useCaseController);
    assertEquals("1", lastCharacterOfLine(bodyLines().get(0)));
  }

  @Test
  public void testWriteLastRowNumberAtLastOfLine() {
    when(this.useCaseController.getDimension()).thenReturn(DIMENSION);
    this.gameView.write(useCaseController);
    assertEquals("5", lastCharacterOfLine(boardLine(DIMENSION)));
  }

  @Test
  public void testWriteBlackPieces() {
    when(this.useCaseController.getDimension()).thenReturn(DIMENSION);
    when(this.useCaseController.getPiece(coordinate(0, 0))).thenReturn(pawn(black));
    when(this.useCaseController.getPiece(coordinate(0, 2))).thenReturn(pawn(black));
    when(this.useCaseController.getPiece(coordinate(0, 4))).thenReturn(pawn(black));

    this.gameView.write(useCaseController);
    assertEquals("1n n n1", boardLine(1));
  }

  @Test
  public void testWriteWhitePieces() {
    when(this.useCaseController.getDimension()).thenReturn(DIMENSION);
    when(this.useCaseController.getPiece(coordinate(3, 1))).thenReturn(pawn(white));
    when(this.useCaseController.getPiece(coordinate(3, 3))).thenReturn(pawn(white));

    this.gameView.write(useCaseController);
    assertEquals("4 b b 4", boardLine(4));
  }

  @Test
  public void testWriteNullPieceWriteSpace() {
    when(this.useCaseController.getDimension()).thenReturn(DIMENSION);
    when(this.useCaseController.getPiece(coordinate(0, 0))).thenReturn(pawn(black));
    when(this.useCaseController.getPiece(coordinate(0, 2))).thenReturn(pawn(white));

    this.gameView.write(useCaseController);
    assertEquals("1n b  1", boardLine(1));
  }

  @Test
  public void testWriteDraught() {
    when(this.useCaseController.getDimension()).thenReturn(DIMENSION);
    when(this.useCaseController.getPiece(coordinate(2, 0))).thenReturn(draught(black));
    when(this.useCaseController.getPiece(coordinate(2, 4))).thenReturn(draught(white));

    this.gameView.write(useCaseController);
    assertEquals("3N   B3", boardLine(3));
  }

  private List<String> bodyLines() {
    String output = this.outContent.toString();
    List<String> lines = new ArrayList<>(Arrays.asList(output.split("\r\n")));
    lines.remove(0);
    lines.remove(lines.size() - 1);
    return lines;
  }

  private String boardLine(int position) {
    return bodyLines().get(position - 1);
  }

  private String lastCharacterOfLine(String line) {
    List<String> characters = Arrays.asList(line.split(""));
    return characters.get(characters.size() - 1);
  }

  private String firstCharacterOfLine(String line) {
    List<String> characters = Arrays.asList(line.split(""));
    return characters.get(0);
  }

  private List<String> topAndBottomNumberLines() {
    String output = this.outContent.toString();
    String[] lines = output.split("\r\n");
    List<String> numberLines = new ArrayList<>();
    numberLines.add(lines[0]);
    numberLines.add(lines[lines.length - 1]);
    return numberLines;
  }

  private Pawn pawn(Color paletteColor) {
    return new Pawn(paletteColor);
  }

  private Draught draught(Color paletteColor) {
    return new Draught(paletteColor);
  }

  private Coordinate coordinate(int row, int column) {
    return new Coordinate(row, column);
  }

}
