package assignment_5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardComparatorTest {

	private Card s1;
	private Card h1;
	private Card d1;
	private Card c1;
	private Card s13;
	private Card h13;
	private Card d13;
	private Card c13;
	private Collection<Card> expected;
	private List<Card> cards;

	private static void testCards(Collection<Card> actualCards, Collection<Card> expectedCards) {
		Iterator<Card> actual = actualCards.iterator();
		Iterator<Card> expected = expectedCards.iterator();

		while (expected.hasNext()) {
			assertTrue(actual.hasNext());

			Card actualCard = actual.next();
			Card expectedCard = expected.next();
			assertEquals(expectedCard.getSuit(), actualCard.getSuit(), String
					.format("Kortstokken skulle vært %s, men var %s", expectedCards, actualCards));
			assertEquals(expectedCard.getFace(), actualCard.getFace(), String
					.format("Kortstokken skulle vært %s, men var %s", expectedCards, actualCards));
		}
	}

	@BeforeEach
	public void setUp() {
		s1 = new Card('S', 1);
		h1 = new Card('H', 1);
		d1 = new Card('D', 1);
		c1 = new Card('C', 1);
		s13 = new Card('S', 13);
		h13 = new Card('H', 13);
		d13 = new Card('D', 13);
		c13 = new Card('C', 13);
		cards = new ArrayList<>(List.of(s1, s13, h1, h13, d1, d13, c1, c13));
	}

	@Test
	@DisplayName("Sjekk at kortstokken blir sortert til med ess som lavest")
	public void testNormal() {
		expected = List.of(c1, c13, d1, d13, h1, h13, s1, s13);
		cards.sort(new CardComparator(false, ' '));
		CardComparatorTest.testCards(cards, expected);
	}

	@Test
	@DisplayName("Sjekk at kortstokken blir sortert med ess som høyest")
	public void testAceIsHighest() {
		expected = List.of(c13, c1, d13, d1, h13, h1, s13, s1);
		cards.sort(new CardComparator(true, ' '));
		CardComparatorTest.testCards(cards, expected);
	}

	@Test
	@DisplayName("Sjekk at kortstokken blir sortert riktig med ruter som trumf")
	public void testDiamondIsTrumph() {
		expected = List.of(c1, c13, h1, h13, s1, s13, d1, d13);
		cards.sort(new CardComparator(false, 'D'));
		CardComparatorTest.testCards(cards, expected);
	}
}
