package assignment_3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardDeckTest {

	private void checkDeck(CardDeck deck, List<String> expected) {
		assertEquals(expected.size(), deck.getCardCount(), "Wrong number of cards in deck");

		for (int i = 0; i < expected.size(); i++) {
			String expectedCard = expected.get(i);
			Card actual = deck.getCard(i);

			String cardString = String.valueOf(actual.getSuit()) + actual.getFace();
			assertEquals(expectedCard, cardString);
		}
	}

	@Test
	@DisplayName("Constructor")
	public void testConstructor() {
		assertThrows(IllegalArgumentException.class, () -> new CardDeck(-1));
		assertThrows(IllegalArgumentException.class, () -> new CardDeck(14));

		this.checkDeck(new CardDeck(0), Collections.emptyList());
		this.checkDeck(new CardDeck(2), List.of("S1", "S2", "H1", "H2", "D1", "D2", "C1", "C2"));
	}

	@Test
	@DisplayName("#shufflePerfectly()")
	public void testShufflePerfectly() {
		CardDeck cardDeck = new CardDeck(2);
		cardDeck.shufflePerfectly();
		this.checkDeck(cardDeck, List.of("S1", "D1", "S2", "D2", "H1", "C1", "H2", "C2"));
	}
}
