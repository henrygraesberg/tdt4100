package assignment_7.train;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import assignment_7.train.PassengerCar;

public class PassengerCarTest {

	private PassengerCar passengerCar;

	@BeforeEach
	public void setUp() {
		passengerCar = new PassengerCar(3000, 200);
	}

	@Test
	@DisplayName("Sjekke totalvekt")
	public void testWeight() {
		assertEquals(3000 + (200 * 80), passengerCar.getTotalWeight(),
				"Teste totalvekt etter initialisering");

		passengerCar.setPassengerCount(100);
		assertEquals(3000 + (100 * 80), passengerCar.getTotalWeight(),
				"Teste totalvekt etter endret antall passasjerer");
		assertEquals(100, passengerCar.getPassengerCount(),
				"Teste antall passasjerer etter endret antall");
	}
}
