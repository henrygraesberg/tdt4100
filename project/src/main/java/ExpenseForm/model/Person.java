package ExpenseForm.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a person who can have expenses.
 * Each person has a name, email, and a list of associated expenses.
 */
public class Person implements Comparable<Person> {
  private String name, email;
  private List<Expense> expenses;

  /**
   * Creates a new Person with the specified name and email.
   * 
   * @param name The person's name
   * @param email The person's email address
   * @throws IllegalArgumentException if name or email is null
   */
  public Person(String name, String email) {
    if(name == null || email == null)
      throw new IllegalArgumentException("Name and email must not be null");

    this.name = name;
    this.email = email;
    expenses = new ArrayList<Expense>();
  }

  /**
   * Returns the person's name.
   * 
   * @return The person's name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Splits the person's name into first name(s) and last name.
   * Assumes the last word in the name is the last name, and everything before is the first name(s).
   * 
   * @return A string array where index 0 contains all first names and index 1 contains the last name
   */
  public String[] getNameSplit() {
    String[] namesSplit = this.name.split(" ");
    String lastName = namesSplit[namesSplit.length - 1];
    String remainingNames = this.name.replace(" " + lastName, "");

    return new String[]{remainingNames, lastName};
  }

  /**
   * Returns the person's email address.
   * 
   * @return The person's email address
   */
  public String getEmail() {
    return this.email;
  }
  
  /**
   * Checks if this person matches the provided name and email.
   * 
   * @param name The name to check against
   * @param email The email to check against
   * @return true if both name and email match, false otherwise
   */
  public boolean isPerson(String name, String email) {
    return this.name.equals(name) && this.email.equals(email);
  }

  /**
   * Adds an expense to this person's list of expenses.
   * If an expense with the same UUID already exists, the expense is not added.
   * 
   * @param expense The expense to add
   */
  public void addExpense(Expense expense) {
    if(expenses.stream().anyMatch(existing -> existing.getUUID().equals(expense.getUUID())))
      return;

    expenses.add(expense);
  }

  /**
   * Returns an List containing the expenses associated with this person
   * 
   * @return List<Expense> with the expenses
   */
  public List<Expense> getExpenses() {
    return this.expenses;
  }

  /**
   * Returns the number of expenses associated with this person.
   * 
   * @return The count of expenses
   */
  public int getAmountOfExpenses() {
    return expenses.size();
  }

  /**
   * Calculates the total value of all expenses associated with this person.
   * 
   * @return The sum of all expense values
   */
  public double getTotalExpenseValue() {
    return expenses.stream()
                    .mapToDouble(expense -> expense.getValue())
                    .sum();
  }

  /**
   * Compares this person with another person for order based on last name, then first name.
   * This method is used for sorting people in alphabetical order by last name first,
   * then by first name if last names are identical.
   *
   * @param otherPerson The person to be compared
   * @return A negative integer, zero, or positive integer as this person is
   *         less than, equal to, or greater than the specified person
   */
  @Override
  public int compareTo(Person otherPerson) {
    String[] thisNames = this.getNameSplit();
    String[] otherNames = otherPerson.getNameSplit();

    int comparison = thisNames[1].compareTo(otherNames[1]);

    if(comparison == 0)
      comparison = thisNames[0].compareTo(otherNames[0]);

    return comparison;
  }

  /**
   * Returns a string representation of this person in the format: "name (email)".
   * 
   * @return A string representation of the person
   */
  @Override
  public String toString() {
    return this.name + " (" + this.email + ")";
  }
}
