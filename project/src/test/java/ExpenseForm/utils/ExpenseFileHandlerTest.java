package ExpenseForm.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ExpenseForm.model.Expense;
import ExpenseForm.model.Person;

/**
 * A class testing the file handler for expenses.
 * Designed to be run in a directory without a file named the same as FILE_NAME,
 * and to be run in order.
 * This is because the first test (testReadNonExistingFile) creates the file and adds the header,
 * the second test (testWriteToFile) expects the file to already exist, but only contain the header,
 * and the third test (testNotEmptyFile) reads the lines the last test wrote to the file
 */
public class ExpenseFileHandlerTest {
	private Person person;
  private Expense expense1;
  private Expense expense2;
	private final String FILE_NAME = "expensesTest.csv";
  
  @BeforeEach
  void setUp() {
      // Create a test person
      person = new Person("John Doe", "john.doe@example.com");

			// Preset the UUID and timestamp so the testNotEmptyFile() doesn't compare two different UUIDs
			UUID expense1uuid = UUID.fromString("1d9ce1a8-2b71-5c85-83cd-4beb61104c3");
			UUID expense2uuid = UUID.fromString("f0fe3a54-0e9c-5bf4-a484-1bdb023859ef");

			Instant expense1timestamp = Instant.parse("2025-04-11T12:30:01.713855Z");
			Instant expense2timestamp = Instant.parse("2025-04-11T12:30:01.743027Z");
      
      // Create two expenses for testing with this person
      expense1 = new Expense(100.0f, 12345678901L, person, "Office supplies", "Bought pens", expense1uuid, expense1timestamp, Expense.Status.PENDING);
      expense2 = new Expense(200.0f, 12345678901L, person, "Lunch", "Team lunch", expense2uuid, expense2timestamp, Expense.Status.PAID);
  }

	void testReadNonExistingFile() {
		ArrayList<Expense> emptyArrayList = ExpenseFileHandler.readCSV(FILE_NAME);

		assertArrayEquals(new Expense[]{}, emptyArrayList.toArray(new Expense[]{}));
	}

	void testWriteToFile() {
		ExpenseFileHandler.writeExpenseToFile(FILE_NAME, expense1);
		ExpenseFileHandler.writeExpenseToFile(FILE_NAME, expense2);
	}

	void testNotEmptyFile() {
		ArrayList<Expense> expensesArrayList = ExpenseFileHandler.readCSV(FILE_NAME);

		assertArrayEquals(
			new Expense[]{expense1, expense2}, 
			expensesArrayList.toArray(new Expense[]{})
		);
	}
	
	@Test
	void testEverytingInOrder() {
		testReadNonExistingFile();
		testWriteToFile();
		testNotEmptyFile();
	}
}
