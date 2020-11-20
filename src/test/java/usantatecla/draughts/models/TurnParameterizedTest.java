package usantatecla.draughts.models;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TurnParameterizedTest {
	
	private int turnChanges;
	
	private ColorPalette expectedTurn;
	private ColorPalette expectedOppositeTurn;
	
   public TurnParameterizedTest(int turnChanges, ColorPalette expectedTurn, ColorPalette expectedOppositeTurn) {
	      this.turnChanges = turnChanges;
	      this.expectedTurn = expectedTurn;
	      this.expectedOppositeTurn = expectedOppositeTurn;
	   }
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
			{ 0, ColorPalette.WHITE, ColorPalette.BLACK },
			{ 2, ColorPalette.WHITE, ColorPalette.BLACK },
			{ 3, ColorPalette.BLACK, ColorPalette.WHITE}, 
		});
	}
	
	private Turn turn;
	
	@Before
	public void before() {
		this.turn = new Turn();
		for (int i = 0; i < this.turnChanges; i++) {
			this.turn.change();
		}
	}
	
	@Test
	public void testWhenChangeTurnThenExpectedTurnIsCorrect() {
		assertEquals(this.turn.getColor(), expectedTurn);
	}
	
	@Test
	public void testWhenChangeTurnThenExpectedOppositeTurnIsCorrect() {
		assertEquals(this.turn.getOppositeColor(), expectedOppositeTurn);
	}
}
