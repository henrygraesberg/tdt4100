package assignment_7.train;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrainCarTest {

	private TrainCar trainCar;

	@BeforeEach
	public void setUp() {
		trainCar = new TrainCar(3000);
	}

	@Test
	@DisplayName("Død vekt er lik totalvekt")
	public void testDeadWeight() {
		assertEquals(3000, trainCar.getTotalWeight(), "Teste initialisering av dødvekt");

		trainCar.setDeadWeight(5000);
		assertEquals(5000, trainCar.getTotalWeight(), "Teste at totalvekt er lik satt dødvekt");
	}
}
