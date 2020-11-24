// package usantatecla.draughts.models;
//
// import static org.junit.Assert.assertEquals;
//
// import java.util.Arrays;
// import java.util.Collection;
//
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.junit.runners.Parameterized;
// import org.junit.runners.Parameterized.Parameters;
//
// @RunWith(Parameterized.class)
// public class TurnParameterizedTest {
//
// private int turnChanges;
//
// private PaletteColor expectedTurn;
// private PaletteColor expectedOppositeTurn;
//
// public TurnParameterizedTest(int turnChanges, PaletteColor expectedTurn, PaletteColor
// expectedOppositeTurn) {
// this.turnChanges = turnChanges;
// this.expectedTurn = expectedTurn;
// this.expectedOppositeTurn = expectedOppositeTurn;
// }
//
// @Parameters
// public static Collection<Object[]> data() {
// return Arrays.asList(new Object[][] {
// { 0, PaletteColor.WHITE, PaletteColor.BLACK },
// { 2, PaletteColor.WHITE, PaletteColor.BLACK },
// { 3, PaletteColor.BLACK, PaletteColor.WHITE},
// });
// }
//
// private Turn turn;
//
// @Before
// public void before() {
// this.turn = new Turn();
// for (int i = 0; i < this.turnChanges; i++) {
// this.turn.change();
// }
// }
//
// @Test
// public void testWhenChangeTurnThenExpectedTurnIsCorrect() {
// assertEquals(this.turn.getColor(), expectedTurn);
// }
//
// @Test
// public void testWhenChangeTurnThenExpectedOppositeTurnIsCorrect() {
// assertEquals(this.turn.getOppositeColor(), expectedOppositeTurn);
// }
// }
