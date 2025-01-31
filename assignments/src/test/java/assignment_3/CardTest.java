package assignment_3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

	private boolean checkState(Card card, char suit, int face) {
		return card.getSuit() == suit && card.getFace() == face;
	}

	@Test
	@DisplayName("Constructor")
	public void testConstructor() {
		assertTrue(this.checkState(new Card('S', 1), 'S', 1));
		assertTrue(this.checkState(new Card('S', 13), 'S', 13));
		assertTrue(this.checkState(new Card('H', 1), 'H', 1));
		assertTrue(this.checkState(new Card('H', 13), 'H', 13));
		assertTrue(this.checkState(new Card('D', 1), 'D', 1));
		assertTrue(this.checkState(new Card('D', 13), 'D', 13));
		assertTrue(this.checkState(new Card('C', 1), 'C', 1));
		assertTrue(this.checkState(new Card('C', 13), 'C', 13));

		assertThrows(IllegalArgumentException.class, () -> {
			new Card('X', 1);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Card('S', 0);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Card('C', 14);
		});
	}

	@Test
	@DisplayName("#toString()")
	public void testToString() {
		assertEquals("S1", new Card('S', 1).toString());
		assertEquals("H13", new Card('H', 13).toString());
	}
}
