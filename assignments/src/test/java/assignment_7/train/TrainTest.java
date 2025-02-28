package oving7.train;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrainTest {

	private CargoCar cc1;
	private CargoCar cc2;
	private PassengerCar pc1;
	private PassengerCar pc2;
	private Train train;

	@BeforeEach
	public void setUp() {
		train = new Train();
		pc1 = new PassengerCar(2000, 200);
		pc2 = new PassengerCar(1500, 100);
		cc1 = new CargoCar(3000, 5000);
		cc2 = new CargoCar(2500, 7000);
	}

	@Test
	@DisplayName("Legge til vogner i tog")
	public void testAddCarToTrain() {
		train.addTrainCar(pc1);
		train.addTrainCar(pc2);
		train.addTrainCar(cc1);
		assertTrue(train.contains(pc1),
				"Teste om toget inneholder passasjervogn1 etter at den har blitt lagt til");
		assertTrue(train.contains(pc2),
				"Teste om toget inneholder passasjervogn2 etter at den har blitt lagt til");
		assertTrue(train.contains(cc1),
				"Teste om toget inneholder cargovogn1 etter at den har blitt lagt til");
		assertFalse(train.contains(cc2),
				"Teste om toget inneholder cargovogn2 uten at den har blitt lagt til");

		assertThrows(IllegalArgumentException.class, () -> {
			train.addTrainCar(null);
		}, "Teste om det kastes en IllegalArgumentException ved å legge til en null-vogn");
	}

	@Test
	@DisplayName("Sjekke totalvekt på toget")
	public void testTotalTrainWeight() {
		train.addTrainCar(pc1);
		train.addTrainCar(cc1);
		assertEquals(8000 + (2000 + (200 * 80)), train.getTotalWeight(),
				"Teste togets totalvekt etter å ha lagt til en passasjervogn og en cargovogn");

		train.addTrainCar(pc2);
		assertEquals(8000 + (2000 + (200 * 80)) + (1500 + (100 * 80)), train.getTotalWeight(),
				"Teste togets totalvekt etter å ha lagt til enda en passasjervogn");
	}

	@Test
	@DisplayName("Sjekke passasjerantall på toget")
	public void testPassengerCount() {
		train.addTrainCar(pc1);
		train.addTrainCar(pc2);
		assertEquals(300, train.getPassengerCount(),
				"Teste passasjerantall etter å ha lagt til passasjervogner");

		train.addTrainCar(cc1);
		assertEquals(300, train.getPassengerCount(),
				"Teste passasjerantall etter å ha lagt til cargo-vogn");
	}

	@Test
	@DisplayName("Sjekke cargovekt på toget")
	public void testCargoWeight() {
		train.addTrainCar(cc1);
		train.addTrainCar(cc2);
		assertEquals(12000, train.getCargoWeight(),
				"Teste cargovekt etter å ha lagt til cargovogner");

		train.addTrainCar(pc1);
		assertEquals(12000, train.getCargoWeight(),
				"Teste cargovekt etter å ha lagt til passasjervogn");
	}
}
