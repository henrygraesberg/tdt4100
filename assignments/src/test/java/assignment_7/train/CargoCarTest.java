package assignment_7.train;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CargoCarTest {

	private CargoCar cargoCar;

	@BeforeEach
	public void setUp() {
		cargoCar = new CargoCar(3000, 2000);
	}

	@Test
	@DisplayName("Sjekke totalvekt")
	public void testWeight() {
		assertEquals(5000, cargoCar.getTotalWeight(), "Teste totalvekt etter initialisering");

		cargoCar.setCargoWeight(4000);
		assertEquals(7000, cargoCar.getTotalWeight(), "Teste totalvekt etter endret cargo-vekt");
		assertEquals(4000, cargoCar.getCargoWeight(), "Teste cargo-vekt etter endring i vekten");
	}
}
