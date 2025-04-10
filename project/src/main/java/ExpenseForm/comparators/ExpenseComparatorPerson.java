package ExpenseForm.comparators;

import java.util.Comparator;

import ExpenseForm.model.Expense;

/**
 * Comparator for sorting Expense objects by the associated Person.
 * Uses the natural ordering of Person objects, which sorts by last name then first name.
 */
public class ExpenseComparatorPerson implements Comparator<Expense> {
  /**
   * Compares two expenses based on the person who submitted them.
   * 
   * @param expense1 The first expense to compare
   * @param expense2 The second expense to compare
   * @return A negative integer, zero, or positive integer as the first expense's person
   *         is less than, equal to, or greater than the second expense's person
   */
  @Override
  public int compare(Expense expense1, Expense expense2) {
    return expense1.getPerson().compareTo(expense2.getPerson());
  }
}
