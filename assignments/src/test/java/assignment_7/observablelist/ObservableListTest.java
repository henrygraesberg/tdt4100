package assignment_7.observablelist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ObservableListTest {

	private int pos1;
	private int pos2;
	private ObservableList observableList;

	private static void checkObservableList(ObservableList list, List<Integer> elements,
			String contextMessage) {
		assertEquals(elements.size(), list.size(),
				contextMessage + " -> Teste lengden på observableList");

		int i = 0;

		for (int element : elements) {
			assertEquals(element, list.getElement(i),
					contextMessage + " -> Teste at element på plass " + i + " stemmer");

			i++;
		}
	}

	private void addElementWithListener(int pos, int element) {
		pos1 = pos;
		observableList.addElement(pos, element);

		// Sjekke at posisjonen som ble endret er den samme som ble sendt til lytteren
		assertEquals(pos1, pos2, "La til " + element + " på posisjon " + pos
				+ " -> Teste posisjonen mottatt av lytter");
	}

	@BeforeEach
	public void setUp() {
		observableList = new ObservableList() {
			@Override
			public boolean acceptsElement(Object element) {
				return element instanceof Integer;
			}
		};
		pos1 = -1;
		pos2 = -1;
	}

	@Test
	@DisplayName("Teste konstruktør")
	public void testConstructor() {
		assertEquals(0, observableList.size());
	}

	@Test
	@DisplayName("Teste aksept av elementer")
	public void testAcceptsElement() {
		assertTrue(observableList.acceptsElement(5), "Teste at listen aksepterer integer");
		assertFalse(observableList.acceptsElement("5"), "Teste at listen ikke aksepterer string");

		assertThrows(IllegalArgumentException.class, () -> {
			observableList.addElement("5");
		}, "Teste at listen ikke kan ta imot elementer av type string");
	}

	@Test
	@DisplayName("Teste å legge til elementer")
	public void testAddElement() {
		observableList.addElement(5);
		ObservableListTest.checkObservableList(observableList, List.of(5), "La til 5 i tom liste");

		observableList.addElement(6);
		ObservableListTest.checkObservableList(observableList, List.of(5, 6),
				"La til 6 i listen [5]");

		observableList.addElement(0, 2);
		ObservableListTest.checkObservableList(observableList, List.of(2, 5, 6),
				"La til 2 på posisjon 0 i listen [5, 6]");
	}

	@Test
	@DisplayName("Teste lytter")
	public void testListListener() {
		ObservableListListener listener = (list, pos) -> pos2 = pos;
		observableList.addObservableListListener(listener);

		this.addElementWithListener(0, 5);
		ObservableListTest.checkObservableList(observableList, List.of(5), "La til 5 i listen []");

		this.addElementWithListener(1, 6);
		ObservableListTest.checkObservableList(observableList, List.of(5, 6),
				"La til 6 i listen [5]");

		this.addElementWithListener(0, 2);
		ObservableListTest.checkObservableList(observableList, List.of(2, 5, 6),
				"La til 2 i listen [5, 6]");
	}
}
