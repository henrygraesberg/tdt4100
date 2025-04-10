package ExpenseForm.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {
    
    private Person person;
    private Expense expense1;
    private Expense expense2;
    
    @BeforeEach
    void setUp() {
        // Create a test person
        person = new Person("John Doe", "john.doe@example.com");
        
        // Create two expenses for testing with this person
        expense1 = new Expense(100.0f, 12345678901L, person, "Office supplies", "Bought pens");
        expense2 = new Expense(200.0f, 12345678901L, person, "Lunch", "Team lunch");
    }
    
    @Test
    void testConstructor() {
        // Test constructor creates a person correctly
        Person p = new Person("Jane Smith", "jane.smith@example.com");
        assertEquals("Jane Smith", p.getName());
        assertEquals("jane.smith@example.com", p.getEmail());
        assertEquals(0, p.getAmountOfExpenses());
    }
    
    @Test
    void testConstructorWithNullName() {
        // Test that constructor throws exception for null name
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person(null, "email@example.com");
        });
        
        String expectedMessage = "Name and email must not be null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    @Test
    void testConstructorWithNullEmail() {
        // Test that constructor throws exception for null email
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("Test Person", null);
        });
        
        String expectedMessage = "Name and email must not be null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    @Test
    void testGetNameSplit() {
        // Test name splitting for simple case
        String[] nameParts = person.getNameSplit();
        assertEquals("John", nameParts[0]);
        assertEquals("Doe", nameParts[1]);
        
        // Test with multi-word first name
        Person personWithMultipleFirstNames = new Person("John James Doe", "jjd@example.com");
        String[] multiNameParts = personWithMultipleFirstNames.getNameSplit();
        assertEquals("John James", multiNameParts[0]);
        assertEquals("Doe", multiNameParts[1]);
    }
    
    @Test
    void testIsPerson() {
        // Test positive match
        assertTrue(person.isPerson("John Doe", "john.doe@example.com"));
        
        // Test negative match - wrong name
        assertFalse(person.isPerson("Jane Doe", "john.doe@example.com"));
        
        // Test negative match - wrong email
        assertFalse(person.isPerson("John Doe", "jane.doe@example.com"));
        
        // Test negative match - both wrong
        assertFalse(person.isPerson("Jane Doe", "jane.doe@example.com"));
    }
    
    @Test
    void testAddExpenseAndGetExpenses() {
        // The person already has 2 expenses from setup
        assertEquals(2, person.getAmountOfExpenses());
        assertEquals(2, person.getExpenses().size());
        
        // Add another expense
        Expense expense3 = new Expense(150.0f, 12345678901L, person, "Travel", "Bus ticket");
        assertEquals(3, person.getAmountOfExpenses());
        
        // Verify the expenses are in the person's expense list
        assertTrue(person.getExpenses().contains(expense1));
        assertTrue(person.getExpenses().contains(expense2));
        assertTrue(person.getExpenses().contains(expense3));
    }
    
    @Test
    void testAddDuplicateExpense() {
        // Create a duplicate expense with the same UUID (this is a contrived test since the default constructor 
        // would generate a unique UUID, so we're creating a specific expense with specified UUID)
        UUID uuid = expense1.getUUID();
        Instant timestamp = expense1.getTimestamp();
        Expense duplicateExpense = new Expense(
            100.0f, 12345678901L, person, "Office supplies", "Bought pens",
            uuid, timestamp, Expense.Status.PENDING
        );
        
        // The person should still have just 2 expenses (the duplicate shouldn't be added)
        assertEquals(2, person.getAmountOfExpenses());
    }
    
    @Test
    void testGetTotalExpenseValue() {
        // Total should be the sum of expense1 and expense2
        double expectedTotal = expense1.getValue() + expense2.getValue();
        assertEquals(expectedTotal, person.getTotalExpenseValue(), 0.001);
        
        // Add another expense and check again
        Expense expense3 = new Expense(150.0f, 12345678901L, person, "Travel", "Bus ticket");
        expectedTotal += expense3.getValue();
        assertEquals(expectedTotal, person.getTotalExpenseValue(), 0.001);
    }
    
    @Test
    void testCompareTo() {
        // Create persons with different names for comparison
        Person p1 = new Person("Adam Smith", "adam@example.com");
        Person p2 = new Person("Bob Jones", "bob@example.com");
        Person p3 = new Person("Charlie Smith", "charlie@example.com");
        
        // Compare by last name, then first name
        assertTrue(p1.compareTo(p2) > 0); // Smith > Jones
        assertTrue(p2.compareTo(p1) < 0); // Jones < Smith
        assertTrue(p1.compareTo(p3) < 0); // Adam Smith < Charlie Smith (same last name, compare first name)
        assertTrue(p3.compareTo(p1) > 0); // Charlie Smith > Adam Smith
        assertEquals(0, p1.compareTo(new Person("Adam Smith", "different@example.com"))); // Same names
    }
    
    @Test
    void testToString() {
        assertEquals("John Doe (john.doe@example.com)", person.toString());
    }
}