package ExpenseForm.comparators;

import java.util.Comparator;
import java.util.List;

import ExpenseForm.model.Expense;

/**
 * Comparator for sorting Expense objects by the associated Status.
 * Sorts based on the order they appear in {@link Expense.Status}
 */
public class ExpenseComparatorStatus implements Comparator<Expense> {
  /**
   * Compares two expenses based on their statuses
   * They are ordered based on the order they appear in {@link Expense.Status},
   * i.e. PENDING comes before REJECTED (returns -1 if {@code expense1.getStatus()} is PENDING and {@code expense2.getStatus()} is REJECTED) and REJECTED comes before PAID
   * 
   * @param expense1 The first expense to compare
   * @param expense2 The second expense to compare
   * @return A negative integer, zero, or positive integer as the first expense's person
   *         is less than, equal to, or greater than the second expense's person
   */
  @Override
  public int compare(Expense expense1, Expense expense2) {
    List<Expense.Status> statuses = List.of(Expense.Status.values());

    return statuses.indexOf(expense1.getStatus()) - statuses.indexOf(expense2.getStatus());
  }
}
