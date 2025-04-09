package ExpenseForm.comparators;

import java.util.Comparator;

import ExpenseForm.model.Expense;

public class ExpenseComparatorPerson implements Comparator<Expense> {
  @Override
  public int compare(Expense expense1, Expense expense2) {
    return expense1.getPerson().compareTo(expense2.getPerson());
  }
}
