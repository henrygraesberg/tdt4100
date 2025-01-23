package assignment_2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountTest {

	private Account account;
	private double epsilon = 0.000001d;

	@BeforeEach
	public void setup() {
		account = new Account(100, 5);
	}

	@Test
	@DisplayName("Private fields")
	public void testPrivateFields() {
		TestHelper.checkIfFieldsPrivate(Account.class);
	}

	@Test
	public void testConstructor() {
		assertEquals(100.0d, account.getBalance(), epsilon);
		assertEquals(5.0d, account.getInterestRate(), epsilon);

		assertThrows(IllegalArgumentException.class, () -> new Account(-1, 5));
		assertThrows(IllegalArgumentException.class, () -> new Account(100, -1));
	}

	@Test
	public void testSetInterestRate() {
		account.setInterestRate(7);
		assertEquals(7, account.getInterestRate(), epsilon);

		assertThrows(IllegalArgumentException.class, () -> account.setInterestRate(-2));
	}

	@Test
	public void testDeposit() {
		account.deposit(100);
		assertEquals(200.0d, account.getBalance(), epsilon);

		assertThrows(IllegalArgumentException.class, () -> account.deposit(-50));
	}

	@Test
	public void testWithdraw() {
		account.withdraw(50);
		assertEquals(50.0d, account.getBalance(), epsilon);

		assertThrows(IllegalArgumentException.class, () -> account.withdraw(150));

		assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10));
	}

	@Test
	public void testEmptyAccount() {
		account = new Account();

		assertEquals(0.0d, account.getBalance(), epsilon);

		account.addInterest();
		assertEquals(0.0d, account.getBalance(), epsilon);
	}
}
