package assignment_2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// Test with encapsulation
public class PersonTest2 {

	private Person person;
	private static int[] factors1 = {3, 7, 6, 1, 8, 9, 4, 5, 2};
	private static int[] factors2 = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};

	@BeforeEach
	public void setup() {
		person = new Person();
	}

	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Test constructor")
	public void testConstructor() {
		String name = "Ola Nordmann";
		String email = "ola.nordmann@ntnu.no";
		Date birthday = new Date(94, 0, 1);
		char gender = 'M';
		String ssn = "010194111" + generateValid(1, 1, 1, "010194");

		assertDoesNotThrow(
			() -> person = new Person(name, email, birthday, gender, ssn)
		);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSetSSN() {
		person.setBirthday(new Date(94, 0, 1));
		person.setGender('M');

		assertDoesNotThrow(() -> {
			person.setSSN("010194111" + generateValid(1, 1, 1, "010194"));
		});

		assertEquals("01019411156", person.getSSN());

		assertThrows(Exception.class, () -> {
			person.setSSN("010194112" + generateValid(1, 1, 2, "010194"));
		});

		assertEquals("01019411156", person.getSSN());

		assertThrows(Exception.class, () -> {
			person.setSSN("01019411122");
		});

		assertEquals("01019411156", person.getSSN());

		assertThrows(Exception.class, () -> person.setSSN("123456"));

		assertEquals("01019411156", person.getSSN());

		Person newPerson = new Person("Ola Nordmann", "ola.nordmann@ntnu.no", null, 'M');

		assertThrows(Exception.class, () -> newPerson.setSSN("01019411156"));

		assertEquals(null, newPerson.getSSN());
	}

	private static String generateValid(int n1, int n2, int n3, String birthday) {
		birthday = birthday + n1 + n2 + n3;
		int k1 = 0, k2 = 0;

		for (int i = 0; i < birthday.length(); i++) {
			int num = Character.getNumericValue(birthday.charAt(i));
			k1 += factors1[i] * num;
			k2 += factors2[i] * num;
		}

		k1 = 11 - (k1 % 11);

		if (k1 == 11) {
			k1 = 0;
		}

		k2 += k1 * factors2[9];
		k2 = 11 - (k2 % 11);

		if (k2 == 11) {
			k2 = 0;
		}

		return k1 + "" + k2;
	}
}
