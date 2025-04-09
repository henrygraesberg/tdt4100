package ExpenseForm.comparators;

import java.util.Comparator;
import java.util.List;

import ExpenseForm.model.Expense;

public class ExpenseComparatorStatus implements Comparator<Expense> {
  /**
   * Compares two expenses' statuses and orders them based on the order they appear in {@link Expense.Status},
   * i.e. PENDING comes before REJECTED (returns -1 if {@code expense1.getStatus()} is PENDING and {@code expense2.getStatus()} is REJECTED) and REJECTED comes before PAID
   */
  @Override
  public int compare(Expense expense1, Expense expense2) {
    List<Expense.Status> statuses = List.of(Expense.Status.values());

    return statuses.indexOf(expense1.getStatus()) - statuses.indexOf(expense2.getStatus());
  }
}
