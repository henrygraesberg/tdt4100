package assignment_7.observablelist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ObservableHighscoreListTest {

	private int pos1;
	private int pos2;
	private ObservableHighscoreList highscoreList;

	private static void checkHighscoreList(String contextMessage, ObservableHighscoreList list,
			List<Integer> elements) {
		assertEquals(elements.size(), list.size(),
				contextMessage + " -> Teste lengden på highscore-listen");

		int i = 0;

		for (int element : elements) {
			assertEquals(element, list.getElement(i),
					contextMessage + " -> Teste at element på plass " + i + " stemmer");

			i++;
		}
	}

	private void addResultWithListener(int pos, int element) {
		pos1 = pos;
		highscoreList.addResult(element);

		// Sjekke at posisjonen som ble endret er den samme som ble sendt til lytteren
		assertEquals(pos1, pos2, "La til " + element + " på posisjon " + pos
				+ " -> Teste posisjonen mottatt av lytter");
	}

	@BeforeEach
	public void setUp() {
		highscoreList = new ObservableHighscoreList(3);
		pos1 = -1;
		pos2 = -1;
	}

	@Test
	@DisplayName("Teste konstruktør")
	public void testConstructor() {
		assertEquals(0, highscoreList.size(), "Teste initialisering av highscore-listen");
	}

	@Test
	@DisplayName("Legge til resultater (enkel)")
	public void testAddElementSimple() {
		highscoreList.addResult(5);
		ObservableHighscoreListTest.checkHighscoreList("La til 5 i tom liste", highscoreList,
				List.of(5));

		highscoreList.addResult(6);
		ObservableHighscoreListTest.checkHighscoreList("La til 6 i listen [5]", highscoreList,
				List.of(5, 6));

		highscoreList.addResult(2);
		ObservableHighscoreListTest.checkHighscoreList("La til 2 i listen [5, 6]", highscoreList,
				List.of(2, 5, 6));
	}

	@Test
	@DisplayName("Legge til resultater - listen blir for lang")
	public void testAddElementMoreThanMax() {
		highscoreList.addResult(5);
		highscoreList.addResult(6);
		highscoreList.addResult(2);
		ObservableHighscoreListTest.checkHighscoreList("La til 5, 6 og 2 i listen", highscoreList,
				List.of(2, 5, 6));

		highscoreList.addResult(3);
		ObservableHighscoreListTest.checkHighscoreList("La til 3 i listen [2, 5, 6]", highscoreList,
				List.of(2, 3, 5));

		highscoreList.addResult(7);
		ObservableHighscoreListTest.checkHighscoreList("La til 7 i listen [2, 3, 5]", highscoreList,
				List.of(2, 3, 5));
	}

	@Test
	@DisplayName("Legge til to like elementer")
	public void testAddElementDuplicate() {
		highscoreList.addResult(5);
		highscoreList.addResult(6);
		highscoreList.addResult(2);
		ObservableHighscoreListTest.checkHighscoreList("La til 5, 6 og 2 i listen", highscoreList,
				List.of(2, 5, 6));

		highscoreList.addResult(2);
		ObservableHighscoreListTest.checkHighscoreList("La til 2 i listen [2, 5, 6]", highscoreList,
				List.of(2, 2, 5));
	}

	@Test
	@DisplayName("Teste lyttere (enkel)")
	public void testListListenersSimple() {
		// Mocke en lytter
		ObservableListListener listener = (list, pos) -> pos2 = pos;
		highscoreList.addObservableListListener(listener);

		this.addResultWithListener(0, 5);
		ObservableHighscoreListTest.checkHighscoreList("La til 5 i listen []", highscoreList,
				List.of(5));

		this.addResultWithListener(1, 6);
		ObservableHighscoreListTest.checkHighscoreList("La til 6 i listen [5]", highscoreList,
				List.of(5, 6));

		this.addResultWithListener(0, 2);
		ObservableHighscoreListTest.checkHighscoreList("La til 2 i listen [5, 6]", highscoreList,
				List.of(2, 5, 6));
	}

	@Test
	@DisplayName("Med lytter - listen blir for lang")
	public void testListListenerMoreThanMax() {
		// Mocke en lytter
		ObservableListListener listener = (list, pos) -> pos2 = pos;
		highscoreList.addObservableListListener(listener);

		highscoreList.addResult(5);
		highscoreList.addResult(6);
		highscoreList.addResult(2);
		ObservableHighscoreListTest.checkHighscoreList("La til 5, 6 og 2 i listen", highscoreList,
				List.of(2, 5, 6));

		this.addResultWithListener(1, 3);
		ObservableHighscoreListTest.checkHighscoreList("La til 3 i listen [2, 5, 6]", highscoreList,
				List.of(2, 3, 5));

		// Nullstille pos2 siden neste element havner utenfor listen og blir dermed ikke
		// oppdatert av seg selv og sendt til lytter
		pos2 = -1;
		this.addResultWithListener(-1, 7);
		ObservableHighscoreListTest.checkHighscoreList("La til 7 i listen [2, 3, 5]", highscoreList,
				List.of(2, 3, 5));
	}

	@Test
	@DisplayName("Med lytter - to like elementer")
	public void testListListenerDuplicate() {
		// Mocke en lytter
		ObservableListListener listener = (list, pos) -> pos2 = pos;
		highscoreList.addObservableListListener(listener);

		highscoreList.addResult(5);
		highscoreList.addResult(6);
		highscoreList.addResult(2);
		ObservableHighscoreListTest.checkHighscoreList("La til 5, 6 og 2 i listen", highscoreList,
				List.of(2, 5, 6));

		this.addResultWithListener(1, 2);
		ObservableHighscoreListTest.checkHighscoreList("La til 2 i listen [2, 5, 6]", highscoreList,
				List.of(2, 2, 5));
	}
}
