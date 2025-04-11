package ExpenseForm.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.time.Instant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import ExpenseForm.model.Expense;
import ExpenseForm.model.Person;

public class ExpenseFileHandler {
  /**
   * Reads expense data from a CSV file.
   * Creates a new file with header if the specified file is not found.
   *
   * @param filename The path to the CSV file to read
   * @return An ArrayList of Expense objects parsed from the file
   */
  public static ArrayList<Expense> readCSV(String filename) {
    ArrayList<Expense> expenses = new ArrayList<Expense>();

    try {
      Scanner fileReader = new Scanner(new FileReader(filename));

      // First line contains header information to make csv more human readable,
      // so we skip it
      fileReader.nextLine();
      int lineNr = 1;

      while(fileReader.hasNext()) {
        try {
          lineNr++;
          expenses.add(parseExpenseString(fileReader.nextLine()));
        } catch (Exception e) {
          System.err.println("Error parsing line " + lineNr + ": " + e);
        }
      }

      fileReader.close();
    } catch (FileNotFoundException e) {
      System.err.println("Could not read from file " + filename);
      System.err.println("Creating new file");

      try {
        FileWriter outputFile = new FileWriter(filename, true);
        outputFile.write("uuid,timestamp,value,accountNumber,reason,comment,personName,personEmail,status\n");
        outputFile.flush();
        outputFile.close();
      } catch (IOException err) {
        System.err.println("Could not write to file " + filename);
      }
    }

    return expenses;
  }

  /**
   * Parses a comma-separated string into an Expense object.
   *
   * @param input A comma-separated string containing expense data
   * @return An Expense object with the parsed data
   * @throws IllegalArgumentException if the input string contains invalid status or an invalid UUID
   * @throws DateTimeParseException if the timestamp does not conform to the ISO instant format
   * @throws NumberFormatException if the value is not parsable as a float or the account number is not parsable as a long
   */
  public static Expense parseExpenseString(String input) {
    String[] inputSplit = input.split(",");

    UUID uuid = UUID.fromString(inputSplit[0]);
    Instant timestamp = Instant.parse(inputSplit[1]);
    float value = Float.parseFloat(inputSplit[2]);
    long accountNr = Long.parseLong(inputSplit[3]);
    String reason = inputSplit[4], comment = inputSplit[5], name = inputSplit[6], email = inputSplit[7];
    Person person = new Person(name, email);
    Expense.Status status;

    switch(inputSplit[8]) {
      case "PENDING":
        status = Expense.Status.PENDING;
        break;
      case "PAID":
        status = Expense.Status.PAID;
        break;
      case "REJECTED":
        status = Expense.Status.REJECTED;
        break;
      default:
        throw new IllegalArgumentException("String does not contain expense status");
    }

    return new Expense(value, accountNr, person, reason, comment, uuid, timestamp, status);
  }

  /**
   * Writes an expense object to a CSV file.
   *
   * @param filename The path to the file where the expense will be written
   * @param expense The Expense object to write to the file
   */
  public static void writeExpenseToFile(String filename, Expense expense) {
    try {
      FileWriter outputFile = new FileWriter(filename, true);
      outputFile.write(expense.toStringAll() + "\n");
      outputFile.flush();
      outputFile.close();
    } catch (IOException e) {
      System.err.println("Could not write to file " + filename);
    }
  }

  /**
   * Updates a specific line in a CSV file with new expense information.
   *
   * @param filename The path to the file to update
   * @param updatedLine The line number to update (0-based)
   * @param updatedExpenseString The new expense data as a comma-separated string
   * 
   * @see {@link ExpenseForm.model.Expense#toStringAll} for csv formatting
   */
  public static void updateExpenseLine(String filename, int updatedLine, String updatedExpenseString) {
    List<String> lines = new ArrayList<String>();

    try {
      Scanner scanner = new Scanner(new FileReader(filename));

      while(scanner.hasNext()) {
        lines.add(scanner.nextLine());
      }

      scanner.close();
    } catch (FileNotFoundException e) {
      System.err.println("Could not read from file" + filename);
    }

    lines.remove(updatedLine);
    lines.add(updatedLine, updatedExpenseString);

    try {
      FileWriter outputFile = new FileWriter(filename);

      lines.stream().filter(str -> !str.equals("")).forEach(str -> {
        try {
          outputFile.write(str + "\n");
        } catch (Exception e) {
          System.err.println("Error writing line to file " + filename);
        }
      });

      outputFile.flush();
      outputFile.close();
    } catch (IOException e) {
      System.err.println("Could not write to file " + filename);
    }
  }
}
