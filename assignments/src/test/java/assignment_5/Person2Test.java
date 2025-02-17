package assignment_5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Person2Test {

	private Person2 person1;
	private String h;
	private String t;

	@BeforeEach
	public void setUp() {
		h = "Hallvard";
		t = "Trætteberg";
		person1 = new Person2(String.format("%s %s", h, t));
	}

	private static void testName(Person2 person, String givenName, String lastName) {
		assertEquals(givenName, person.getGivenName());
		assertEquals(lastName, person.getFamilyName());
		assertEquals(String.format("%s %s", givenName, lastName), person.getFullName());
	}

	@Test
	@DisplayName("Sjekk at konstruktøren gir personen riktig navn")
	public void testConstructor() {
		Person2Test.testName(person1, h, t);
	}

	@Test
	@DisplayName("Sjekk at setGivenName() gir riktig navn")
	public void testSetGivenName() {
		String j = "Jens";
		person1.setGivenName(j);
		Person2Test.testName(person1, j, t);
	}

	@Test
	@DisplayName("Sjekk at setFamilyName() gir riktig navn")
	public void testSetFamilyName() {
		String o = "Olsen";
		person1.setFamilyName(o);
		Person2Test.testName(person1, h, o);
	}

	@Test
	@DisplayName("Sjekk at setFullName() gir riktig navn")
	public void testSetFullName() {
		String l = "Lisa";
		String e = "Eriksen";
		String fullName = String.format("%s %s", l, e);
		person1.setFullName(fullName);
		Person2Test.testName(person1, l, e);
	}
}
