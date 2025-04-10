package ExpenseForm.comparators;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ExpenseForm.model.Expense;
import ExpenseForm.model.Person;

class ExpenseComparatorsTest {
    
    private Person person1;
    private Person person2;
    private Expense expensePendingP1;   // Pending status, Person 1
    private Expense expenseRejectedP1;  // Rejected status, Person 1
    private Expense expensePaidP1;      // Paid status, Person 1
    private Expense expensePendingP2;   // Pending status, Person 2
    private List<Expense> expenses;
    
    @BeforeEach
    void setUp() {
        // Create test persons
        person1 = new Person("John Doe", "john@example.com");
        person2 = new Person("Alice Smith", "alice@example.com");
        
        // Create expenses with different statuses and persons
        Instant now = Instant.now();
        
        expensePendingP1 = new Expense(
            100f, 12345678901L, person1, "Reason1", "Comment1",
            UUID.randomUUID(), now, Expense.Status.PENDING
        );
        
        expenseRejectedP1 = new Expense(
            200f, 12345678901L, person1, "Reason2", "Comment2",
            UUID.randomUUID(), now.plusSeconds(60), Expense.Status.REJECTED
        );
        
        expensePaidP1 = new Expense(
            300f, 12345678901L, person1, "Reason3", "Comment3",
            UUID.randomUUID(), now.plusSeconds(120), Expense.Status.PAID
        );
        
        expensePendingP2 = new Expense(
            400f, 12345678901L, person2, "Reason4", "Comment4",
            UUID.randomUUID(), now.plusSeconds(180), Expense.Status.PENDING
        );
        
        // Create a list of expenses to sort
        expenses = new ArrayList<>();
        expenses.add(expensePaidP1);      // Add in non-sorted order
        expenses.add(expensePendingP1);
        expenses.add(expensePendingP2);
        expenses.add(expenseRejectedP1);
    }
    
    @Test
    void testExpenseComparatorStatus() {
        // Test the status comparator
        ExpenseComparatorStatus statusComparator = new ExpenseComparatorStatus();
        
        // Sort expenses by status
        expenses.sort(statusComparator);
        
        // Check if sorted by status: PENDING, REJECTED, PAID
        assertEquals(Expense.Status.PENDING, expenses.get(0).getStatus());
        assertEquals(Expense.Status.PENDING, expenses.get(1).getStatus());
        assertEquals(Expense.Status.REJECTED, expenses.get(2).getStatus());
        assertEquals(Expense.Status.PAID, expenses.get(3).getStatus());
        
        // Test individual comparisons
        assertEquals(-1, statusComparator.compare(expensePendingP1, expenseRejectedP1)); // PENDING < REJECTED
        assertEquals(-1, statusComparator.compare(expenseRejectedP1, expensePaidP1));    // REJECTED < PAID
        assertEquals(-2, statusComparator.compare(expensePendingP1, expensePaidP1));     // PENDING < PAID
        
        assertEquals(1, statusComparator.compare(expenseRejectedP1, expensePendingP1));  // REJECTED > PENDING
        assertEquals(1, statusComparator.compare(expensePaidP1, expenseRejectedP1));     // PAID > REJECTED
        assertEquals(2, statusComparator.compare(expensePaidP1, expensePendingP1));      // PAID > PENDING
        
        assertEquals(0, statusComparator.compare(expensePendingP1, expensePendingP2));   // Same status (PENDING)
    }
    
    @Test
    void testExpenseComparatorPerson() {
        // Test the person comparator
        ExpenseComparatorPerson personComparator = new ExpenseComparatorPerson();
        
        // Sort expenses by person (last name, then first name)
        expenses.sort(personComparator);
        
        // First should be "Doe, John" and last should be "Smith, Alice"
        assertEquals(person1, expenses.get(0).getPerson()); 
        assertEquals(person1, expenses.get(1).getPerson());
        assertEquals(person1, expenses.get(2).getPerson());
        assertEquals(person2, expenses.get(3).getPerson());
        
        // Test individual comparisons
        assertTrue(personComparator.compare(expensePendingP1, expensePendingP2) < 0); // "Doe" < "Smith"
        assertTrue(personComparator.compare(expensePendingP2, expensePendingP1) > 0); // "Smith" > "Doe"
        assertEquals(0, personComparator.compare(expensePendingP1, expenseRejectedP1)); // Same person
    }
    
    @Test
    void testCombinedSorting() {
        // Create expenses with same status but different persons
        Expense expensePendingP1Second = new Expense(
            500f, 12345678901L, person1, "Reason5", "Comment5",
            UUID.randomUUID(), Instant.now(), Expense.Status.PENDING
        );
        expenses.add(expensePendingP1Second);
        
        // Sort by status first, then by person
        expenses.sort(new ExpenseComparatorStatus());
        
        // Within same status group, sort by person
        List<Expense> pendingExpenses = new ArrayList<>();
        List<Expense> rejectedExpenses = new ArrayList<>();
        List<Expense> paidExpenses = new ArrayList<>();
        
        // Group by status
        for (Expense expense : expenses) {
            switch (expense.getStatus()) {
                case PENDING:
                    pendingExpenses.add(expense);
                    break;
                case REJECTED:
                    rejectedExpenses.add(expense);
                    break;
                case PAID:
                    paidExpenses.add(expense);
                    break;
            }
        }
        
        // Sort each group by person
        pendingExpenses.sort(new ExpenseComparatorPerson());
        rejectedExpenses.sort(new ExpenseComparatorPerson());
        paidExpenses.sort(new ExpenseComparatorPerson());
        
        // Clear and rebuild the list in sorted order
        expenses.clear();
        expenses.addAll(pendingExpenses);
        expenses.addAll(rejectedExpenses);
        expenses.addAll(paidExpenses);
        
        // Verify both sorting applied
        // First should be PENDING status with person "Doe, John"
        assertEquals(Expense.Status.PENDING, expenses.get(0).getStatus());
        assertEquals(person1, expenses.get(0).getPerson());
        
        // Last should be PAID status
        assertEquals(Expense.Status.PAID, expenses.get(expenses.size() - 1).getStatus());
    }
    
    @Test
    void testReversedSorting() {
        // Test ascending vs descending sorting
        
        // Sort by status
        expenses.sort(new ExpenseComparatorStatus());
        
        // First should be PENDING, last should be PAID
        assertEquals(Expense.Status.PENDING, expenses.get(0).getStatus());
        assertEquals(Expense.Status.PAID, expenses.get(expenses.size() - 1).getStatus());
        
        // Reverse the order (descending)
        Collections.reverse(expenses);
        
        // First should be PAID, last should be PENDING
        assertEquals(Expense.Status.PAID, expenses.get(0).getStatus());
        assertEquals(Expense.Status.PENDING, expenses.get(expenses.size() - 1).getStatus());
    }
}