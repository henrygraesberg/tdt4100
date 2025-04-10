package ExpenseForm;

import java.time.Instant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ExpenseForm.comparators.ExpenseComparatorPerson;
import ExpenseForm.comparators.ExpenseComparatorStatus;
import ExpenseForm.model.Expense;
import ExpenseForm.model.Expense.Status;
import ExpenseForm.model.Person;
import ExpenseForm.utils.ExpenseFileHandler;

public class ExpenseFormController {
  private final String expensesFilename = "expenses.csv";
  private List<Person> people = new ArrayList<Person>();
  private List<Expense> expenses = new ArrayList<Expense>();

  @FXML TextField valueField, accountField, nameField, emailField, reasonField;
  @FXML TextArea commentField;
  @FXML Button createExpenseButton;

  /**
   * Constructor that initializes the controller by loading existing expenses from the CSV file.
   */
  public ExpenseFormController() {
    ExpenseFileHandler.readCSV(expensesFilename).stream().forEach(expense -> addExpense(expense));
  }

  /**
   * FXML handler method that creates a new expense from the form field values.
   * Performs validation before creating the expense and shows error messages if input is invalid.
   * Clears all fields after successfully creating the expense.
   */
  @FXML
  void onCreateExpense() {
    try {
      // Validate required fields
      if (nameField.getText().trim().isEmpty() || 
          emailField.getText().trim().isEmpty() || 
          valueField.getText().trim().isEmpty() || 
          accountField.getText().trim().isEmpty() || 
          reasonField.getText().trim().isEmpty()) {
        showError("Missing Information", "Please fill in all required fields.");
        return;
      }
      
      // Validate email format (basic validation)
      if (!emailField.getText().contains("@") || !emailField.getText().contains(".")) {
        showError("Invalid Email", "Please enter a valid email address.");
        return;
      }
      
      // Validate numeric fields
      float value;
      long accountNr;
      
      try {
        value = Float.parseFloat(valueField.getText());
        if (value <= 0) {
          showError("Invalid Value", "Value must be a positive number.");
          return;
        }
      } catch (NumberFormatException e) {
        showError("Invalid Value", "Please enter a valid numeric value.");
        return;
      }
      
      try {
        accountNr = Long.parseLong(accountField.getText());
        if (accountNr <= 0) {
          showError("Invalid Account Number", "Account number must be a positive number.");
          return;
        }
      } catch (NumberFormatException e) {
        showError("Invalid Account Number", "Please enter a valid account number.");
        return;
      }
      
      // All validations passed, create the expense
      addNewExpense(
        value,
        accountNr,
        nameField.getText(),
        emailField.getText(),
        reasonField.getText(),
        commentField.getText()
      );

      // Clear fields after successful creation
      valueField.clear();
      accountField.clear();
      nameField.clear();
      emailField.clear();
      reasonField.clear();
      commentField.clear();
      
      // Show success message
      showInfo("Expense Created", "Your expense has been successfully registered.");
      
    } catch (Exception e) {
      showError("Error", "An unexpected error occurred: " + e.getMessage());
    }
  }

  /**
   * Shows an error alert dialog with the specified title and message.
   * 
   * @param title The title of the error dialog
   * @param message The error message to display
   */
  private void showError(String title, String message) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
  
  /**
   * Shows an information alert dialog with the specified title and message.
   * 
   * @param title The title of the information dialog
   * @param message The information message to display
   */
  private void showInfo(String title, String message) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }

  /**
   * Creates a new expense with the provided information and adds it to the expense list.
   * Also writes the new expense to the file.
   *
   * @param value The monetary value of the expense
   * @param accountNr The account number associated with the expense
   * @param name The name of the person submitting the expense
   * @param email The email of the person submitting the expense
   * @param reason The reason for the expense
   * @param comment Any additional comments about the expense
   */
  public void addNewExpense(float value, long accountNr, String name, String email, String reason, String comment) {
    Person person = new Person(name, email);

    Expense newExpense = new Expense(value, accountNr, person, reason, comment);

    addExpense(newExpense);

    ExpenseFileHandler.writeExpenseToFile(expensesFilename, newExpense);
  }

  /**
   * Adds an existing expense to the controller's lists.
   * If the person associated with the expense already exists in the people list,
   * the existing person object is used.
   *
   * @param expense The expense object to add
   */
  private void addExpense(Expense expense) {
    float value = expense.getValue();
    long accountNr = expense.getAccountNr();
    String name = expense.getPersonName();
    String email = expense.getPersonEmail();
    String reason = expense.getReason();
    String comment = expense.getComment();
    UUID uuid = expense.getUUID();
    Instant timeStamp = expense.getTimestamp();
    Expense.Status status = expense.getStatus();
    Person person;

    List<Person> personExists = people.stream().filter(p -> p.isPerson(name, email)).toList();

    if(personExists.size() != 0) person = personExists.get(0);
    else {
      person = expense.getPerson();

      this.people.add(person);
    }

    expenses.add(new Expense(value, accountNr, person, reason, comment, uuid, timeStamp, status));
  }

  /**
   * Updates the status of an expense at the specified index.
   * Also updates the expense information in the CSV file.
   *
   * @param index The index of the expense in the expenses list
   * @param newStatus The new status to set for the expense
   */
  public void updateExpenseStatus(int index, Status newStatus) {
    this.expenses.get(index).setStatus(newStatus);
    String updatedExpenseString = this.expenses.get(index).toStringAll();

    ExpenseFileHandler.updateExpenseLine(expensesFilename, index + 1, updatedExpenseString);
  }

  /**
   * Updates the status of an expense identified by its UUID.
   * Does nothing if no expense with the given UUID is found.
   *
   * @param uuid The UUID of the expense to update
   * @param status The new status to set for the expense
   */
  public void updateExpenseStatus(UUID uuid, Status status) {
    int i = 0;

    for (Expense expense : expenses) {
      if(expense.getUUID().equals(uuid)) break;

      i++;
    }

    if(i > expenses.size()) return;

    updateExpenseStatus(i, status);
  }
  
  public void deleteExpense(int index) {
    this.expenses.remove(index);

    ExpenseFileHandler.updateExpenseLine(expensesFilename, index + 1, "");
  }
  public void deleteExpense(UUID uuid) {
    int i = 0;

    for (Expense expense : expenses) {
      if(expense.getUUID().equals(uuid)) break;

      i++;
    }

    if(i > expenses.size()) return;

    deleteExpense(i);
  }

  public static void main(String[] args) {
    ExpenseFormController controller = new ExpenseFormController();

    System.out.println(controller.people + "\n");
    System.out.println(controller.expenses + "\n\n");

    // Mock data
    String[] names = {"Henry Græsberg", "Emma Johnson", "Markus Olsen", "Sofie Hansen", "Lars Nielsen", 
              "Maria Rodriguez", "Johan Berg", "Sara Karim", "Thomas Andersen", "Mei Lin", 
              "Aleksander Nowak", "Priya Patel", "Lukas Schmidt", "Ingrid Solberg", "Omar Hassan"};
    String[] emails = {"henrygr@stud.ntnu.no", "emma.j@example.com", "markus@example.org", "sofie.h@stud.ntnu.no", "lars.nielsen@example.net", 
              "maria.r@stud.ntnu.no", "johan.b@example.com", "sara.k@example.org", "thomas.a@ntnu.no", "mei.lin@example.net", 
              "aleks@example.com", "priya.p@stud.ntnu.no", "lukas@example.org", "ingrid.s@example.net", "omar.h@example.com"};
    String[] reasons = {"Pizza", "Office supplies", "Travel expenses", "Conference fees", "Team lunch", "Books", 
               "Software license", "Hardware", "Training course", "Phone bill", "Internet expenses", 
               "Parking fees", "Hotel stay", "Printing costs", "Client gifts"};
    String[] comments = {"Team meeting", "Department workshop", "Client visit", "Needed for project", "Monthly meetup", "Emergency purchase", 
              "Professional development", "Remote work expenses", "Field research", "Department celebration", 
              "Required for presentation", "Annual subscription", "Reimbursement request", "Project milestone celebration", "Meeting refreshments"};
    
    // Create x expenses with randomized data
    for (int i = 0; i < 100; i++) {
      float value = 100 + (float)(Math.random() * 2000); // Random value between 100 and 2100
      long accountNr = 10000000000L + (long)(Math.random() * 90000000000L); // Random 11-digit account number
      String name = names[(int)(Math.random() * names.length)];
      String email = emails[(int)(Math.random() * emails.length)];
      String reason = reasons[(int)(Math.random() * reasons.length)];
      String comment = comments[(int)(Math.random() * comments.length)];
      
      controller.addNewExpense(value, accountNr, name, email, reason, comment);
      System.out.println("Added expense: " + value + " kr for " + reason + " by " + name);
    }

    // Randomly assign statuses to x expenses
    Expense.Status[] statuses = Expense.Status.values();
    for (int i = 0; i < 100; i++) {
      if(controller.expenses.isEmpty()) break; // Safety check
      
      // Get random expense index
      int randomExpenseIndex = (int)(Math.random() * controller.expenses.size());
      
      // Get random status
      Expense.Status randomStatus = statuses[(int)(Math.random() * statuses.length)];
      
      // Update expense status
      controller.updateExpenseStatus(randomExpenseIndex, randomStatus);
      System.out.println("Updated expense #" + randomExpenseIndex + " status to " + randomStatus);
    }

    System.out.println(controller.people);
    System.out.println(controller.people.size() + "\n");

    // Sorts by timestamp first,
    Collections.sort(controller.expenses);
    // Then sorts by status
    controller.expenses.sort(new ExpenseComparatorStatus());
    // Then by person
    controller.expenses.sort(new ExpenseComparatorPerson());
    System.out.println(controller.expenses);
    System.out.println(controller.expenses.size() + "\n\n");

    for (Person person : controller.people) {
      System.out.println(person + ": amount of expeses: " + person.getAmountOfExpenses() + " total expense value: " + person.getTotalExpenseValue());
    }

    //controller.deleteExpense(100);
  }
}
