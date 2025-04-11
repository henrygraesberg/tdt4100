package ExpenseForm.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpenseTest {
    
    private Person person;
    private Expense expense;
    private final float VALUE = 123.45f;
    private final long ACCOUNT_NR = 12345678901L;
    private final String REASON = "Office supplies";
    private final String COMMENT = "Bought stationery for the office";
    
    @BeforeEach
    void setUp() {
        person = new Person("John Doe", "john.doe@example.com");
        expense = new Expense(VALUE, ACCOUNT_NR, person, REASON, COMMENT);
    }
    
    @Test
    void testConstructor() {
        // Test basic constructor
        assertEquals(VALUE, expense.getValue());
        assertEquals(ACCOUNT_NR, expense.getAccountNr());
        assertEquals(REASON, expense.getReason());
        assertEquals(COMMENT, expense.getComment());
        assertEquals(person, expense.getPerson());
        assertEquals("John Doe", expense.getPersonName());
        assertEquals("john.doe@example.com", expense.getPersonEmail());
        assertEquals(Expense.Status.PENDING, expense.getStatus());
        assertNotNull(expense.getUUID());
        assertNotNull(expense.getTimestamp());
        
        // Verify the expense is added to the person's expenses
        assertTrue(person.getExpenses().contains(expense));
    }
    
    @Test
    void testSecondaryConstructor() {
        // Test the constructor that sets UUID, timestamp, and status
        UUID uuid = UUID.randomUUID();
        Instant timestamp = Instant.now().minusSeconds(3600); // 1 hour ago
        Expense.Status status = Expense.Status.PAID;
        
        Expense detailedExpense = new Expense(VALUE, ACCOUNT_NR, person, REASON, COMMENT, uuid, timestamp, status);
        
        assertEquals(VALUE, detailedExpense.getValue());
        assertEquals(ACCOUNT_NR, detailedExpense.getAccountNr());
        assertEquals(REASON, detailedExpense.getReason());
        assertEquals(COMMENT, detailedExpense.getComment());
        assertEquals(person, detailedExpense.getPerson());
        assertEquals(uuid, detailedExpense.getUUID());
        assertEquals(timestamp, detailedExpense.getTimestamp());
        assertEquals(status, detailedExpense.getStatus());
    }
    
    @Test
    void testSetStatus() {
        // Initially PENDING
        assertEquals(Expense.Status.PENDING, expense.getStatus());
        
        // Change to REJECTED
        expense.setStatus(Expense.Status.REJECTED);
        assertEquals(Expense.Status.REJECTED, expense.getStatus());
        
        // Change to PAID
        expense.setStatus(Expense.Status.PAID);
        assertEquals(Expense.Status.PAID, expense.getStatus());
    }
    
    @Test
    void testGetters() {
        assertEquals(VALUE, expense.getValue());
        assertEquals(ACCOUNT_NR, expense.getAccountNr());
        assertEquals(REASON, expense.getReason());
        assertEquals(COMMENT, expense.getComment());
        assertEquals(person, expense.getPerson());
        assertEquals("John Doe", expense.getPersonName());
        assertEquals("john.doe@example.com", expense.getPersonEmail());
    }
    
    @Test
    void testCompareToBasedOnTimestamp() {
        // Create expenses with specific timestamps for comparison
        Instant now = Instant.now();
        Instant earlier = now.minusSeconds(3600); // 1 hour earlier
        Instant later = now.plusSeconds(3600);    // 1 hour later
        
        Expense earlierExpense = new Expense(
            VALUE, ACCOUNT_NR, person, REASON, COMMENT, 
            UUID.randomUUID(), earlier, Expense.Status.PENDING
        );
        
        Expense laterExpense = new Expense(
            VALUE, ACCOUNT_NR, person, REASON, COMMENT, 
            UUID.randomUUID(), later, Expense.Status.PENDING
        );
        
        // Test comparisons
        assertTrue(earlierExpense.compareTo(laterExpense) < 0);  // Earlier < Later
        assertTrue(laterExpense.compareTo(earlierExpense) > 0);  // Later > Earlier
        assertEquals(0, earlierExpense.compareTo(earlierExpense)); // Same timestamp
    }
    
    @Test
    void testToString() {
        String expectedFormat = expense.getUUID() + ": " + Expense.Status.PENDING;
        assertEquals(expectedFormat, expense.toString());
    }
    
    @Test
    void testToStringAll() {
        // Create an expense with known values
        UUID uuid = UUID.randomUUID();
        Instant timestamp = Instant.parse("2023-01-01T12:00:00Z");
        Expense testExpense = new Expense(
            100.50f, 12345678901L, 
            new Person("Test Person", "test@example.com"), 
            "Test Reason", "Test Comment",
            uuid, timestamp, Expense.Status.PENDING
        );
        
        String expected = String.format("%1$s,%2$s,%3$s,%4$s,%5$s,%6$s,%7$s,%8$s,%9$s", 
            uuid, timestamp, 100.50f, 12345678901L, "Test Reason", "Test Comment", 
            "Test Person", "test@example.com", Expense.Status.PENDING);
        
        assertEquals(expected, testExpense.toStringAll());
    }
    
    @Test
    void testUUIDGeneration() {
        // Create two expenses with same data but at different times
        Person testPerson = new Person("Same Person", "same@example.com");
        Expense expense1 = new Expense(100f, 12345678901L, testPerson, "Same reason", "Same comment");
        
        // Small delay to ensure different timestamps
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Expense expense2 = new Expense(100f, 12345678901L, testPerson, "Same reason", "Same comment");
        
        // UUIDs should be different because timestamps are different
        assertNotEquals(expense1.getUUID(), expense2.getUUID());
    }
}
