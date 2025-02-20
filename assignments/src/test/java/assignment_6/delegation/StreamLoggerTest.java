package assignment_6.delegation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StreamLoggerTest {

	private static final String formatString = "%s: %s (%s)";
	private static final String melding = "En melding ble logget!";

	private ByteArrayOutputStream stream;
	private StreamLogger logger;

	@BeforeEach
	public void setUp() {
		stream = new ByteArrayOutputStream();
		logger = new StreamLogger(stream);
	}

	@Test
	@DisplayName("Test constructor")
	public void testConstructor() {
		assertThrows(IllegalArgumentException.class, () -> logger = new StreamLogger(null));
	}

	@Test
	@DisplayName("Logger infomelding")
	public void testLog() {
		logger.log(ILogger.INFO, melding, null);
		assertTrue(stream.toString().contains(melding),
				"Teste at strømmen inneholder melding etter at den har blitt logget");
		assertTrue(stream.toString().contains(ILogger.INFO),
				"Teste at strømmen inneholder melding av typen info etter den har blitt logget");
	}

	@Test
	@DisplayName("Logger unntak")
	public void testLogException() {
		assertThrows(IllegalArgumentException.class, () -> {
			logger.setFormatString(null);
		}, "Teste at det kastes IllegalArgumentException når formatet er null");

		IllegalStateException exception = new IllegalStateException();
		logger.setFormatString(formatString);
		logger.log(ILogger.INFO, melding, exception);
		assertEquals(String.format(formatString, ILogger.INFO, melding, exception),
				stream.toString().trim(), "Teste formatet på melding som ble logget med exception");
	}
}
