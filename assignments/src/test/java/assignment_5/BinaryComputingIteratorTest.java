package assignment_5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryComputingIteratorTest {

	private Iterator<Double> iterator1;
	private Iterator<Double> iterator2;
	private Iterator<Double> iteratorShort;

	@BeforeEach
	public void setUp() {
		iterator1 = List.of(0.5, -2.0).iterator();
		iterator2 = List.of(5.0, 3.0).iterator();
		iteratorShort = List.of(5.0).iterator();
	}

	@Test
	@DisplayName("Sjekk BinaryComputingIterator-konstruktør")
	public void testConstructor() {
		assertThrows(IllegalArgumentException.class, () -> {
			new BinaryComputingIterator(null, iterator2, (a, b) -> a * b);
		}, "Iterator1 cannot be null");

		assertThrows(IllegalArgumentException.class, () -> {
			new BinaryComputingIterator(iterator1, null, (a, b) -> a * b);
		}, "Iterator2 cannot be null");

		assertThrows(IllegalArgumentException.class, () -> {
			new BinaryComputingIterator(iterator1, iterator2, null);
		}, "Operator cannot be null");
	}

	@Test
	@DisplayName("Sjekk BinaryComputingIterator med multiplikasjon")
	public void testMultiplication() {
		BinaryComputingIterator binaryIt =
				new BinaryComputingIterator(iterator1, iterator2, (a, b) -> a * b);
		assertEquals(2.5, binaryIt.next(), "Det første tallet var feil");
		assertTrue(binaryIt.hasNext());
		assertEquals(-6.0, binaryIt.next(), "Det andre tallet var feil");
		assertFalse(binaryIt.hasNext());
	}

	@Test
	@DisplayName("Sjekk BinaryComputingIterator med addisjon")
	public void testAddition() {
		BinaryComputingIterator binaryIt =
				new BinaryComputingIterator(iterator1, iterator2, (a, b) -> a + b);
		assertEquals(5.5, binaryIt.next(), "Det første tallet var feil");
		assertTrue(binaryIt.hasNext());
		assertEquals(1.0, binaryIt.next(), "Det andre tallet var feil");
		assertFalse(binaryIt.hasNext());
	}

	@Test
	@DisplayName("Test multiplikasjon med bare ett tall")
	public void testShortIterator() {
		BinaryComputingIterator binaryIt =
				new BinaryComputingIterator(iterator1, iteratorShort, (a, b) -> a * b);
		assertEquals(2.5, binaryIt.next(), "Det første tallet var feil");
		assertFalse(binaryIt.hasNext());
	}

	@Test
	@DisplayName("Test med standardverdi, både et tall og null")
	public void testShortIteratorAndDefault() {
		BinaryComputingIterator binaryIt =
				new BinaryComputingIterator(iterator1, iteratorShort, null, 2.0, (a, b) -> a * b);
		assertEquals(2.5, binaryIt.next(), "Det første tallet var feil");
		assertTrue(binaryIt.hasNext());
		assertEquals(-4.0, binaryIt.next(), "Det andre tallet var feil");
		assertFalse(binaryIt.hasNext());
	}

	@Test
	@DisplayName("Test med en tom iterator")
	public void testEmptyIterator() {
		BinaryComputingIterator binaryIt = new BinaryComputingIterator(Collections.emptyIterator(),
				Collections.emptyIterator(), (a, b) -> a * b);
		assertFalse(binaryIt.hasNext(), "En tom iterator skal ikke ha next");
	}

	@Test
	@DisplayName("Test en tom iterator med standardverdi")
	public void testEmptyIteratorAndDefault() {
		BinaryComputingIterator binaryIt = new BinaryComputingIterator(Collections.emptyIterator(),
				Collections.emptyIterator(), 1.0, 2.0, (a, b) -> a * b);
		assertFalse(binaryIt.hasNext(), "En tom iterator skal ikke ha next");
	}
}
