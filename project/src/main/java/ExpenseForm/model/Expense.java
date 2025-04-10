package ExpenseForm.model;

import java.time.Instant;

import java.util.UUID;

import com.github.f4b6a3.uuid.UuidCreator;

public class Expense implements Comparable<Expense> {
  public enum Status {
    PENDING,
    REJECTED,
    PAID
  }

  private UUID uuid;
  private Instant timestamp;
  private float value;
  private long accountNr;
  private String reason, comment;
  private Person person;
  private Status status;

  /**
   * Creates a new expense with the provided information.
   * Generates a UUID based on person details, reason, value, and timestamp.
   * Sets the initial status to PENDING.
   *
   * @param value The monetary value of the expense
   * @param accountNr The account number associated with the expense
   * @param person The person submitting the expense
   * @param reason The reason for the expense
   * @param comment Any additional comments about the expense
   */
  public Expense(float value, long accountNr, Person person, String reason, String comment) {
    this.timestamp = Instant.now();
    // We use a lot of info to generate UUIDs, since regular time based UUIDs can be identical if we create many expense reports at the same time
    // (Such as if we multithread or even just make some right after each other on the same thread on a fast computer)
    // If we didn't include the time, the same person could for example buy a pizza for the company a couple weeks apart, and end up with the same uuid
    this.uuid = UuidCreator.getNameBasedSha1(person.getName() + person.getEmail() + reason + value + this.timestamp);
    this.value = value;
    this.accountNr = accountNr;
    this.reason = reason;
    this.comment = comment;
    this.person = person;
    this.status = Status.PENDING;

    person.addExpense(this);
  }

  /**
   * Creates an expense with specified UUID, timestamp, and status.
   * Used when loading expenses from storage.
   *
   * @param value The monetary value of the expense
   * @param accountNr The account number the reimbursement should be paid to
   * @param person The person submitting the expense
   * @param reason The reason for the expense
   * @param comment Any additional comments about the expense
   * @param uuid The UUID to use for this expense
   * @param timestamp The timestamp to use for this expense
   * @param status The current status of the expense
   */
  public Expense(float value, long accountNr, Person person, String reason, String comment, UUID uuid, Instant timestamp, Status status) {
    this(value, accountNr, person, reason, comment);

    this.uuid = uuid;
    this.timestamp = timestamp;
    this.status = status;
  }

  /**
   * Updates the status of this expense.
   *
   * @param status The new status to set
   */
  public void setStatus(Status status) {
    this.status = status;
  }

  /**
   * Gets the UUID of this expense.
   *
   * @return The expense UUID
   */
  public UUID getUUID() {
    return this.uuid;
  }

  /**
   * Gets the monetary value of this expense.
   *
   * @return The expense value
   */
  public float getValue() {
    return this.value;
  }

  /**
   * Gets the account number the reimbursement should be paid to.
   *
   * @return The account number
   */
  public long getAccountNr() {
    return this.accountNr;
  }

  /**
   * Gets the reason for this expense.
   *
   * @return The expense reason
   */
  public String getReason() {
    return this.reason;
  }

  /**
   * Gets the comment associated with this expense.
   *
   * @return The expense comment
   */
  public String getComment() {
    return this.comment;
  }

  /**
   * Gets the person who submitted this expense.
   *
   * @return The person object
   */
  public Person getPerson() {
    return this.person;
  }

  /**
   * Gets the name of the person who submitted this expense.
   *
   * @return The person's name
   */
  public String getPersonName() {
    return this.person.getName();
  }

  /**
   * Gets the email of the person who submitted this expense.
   *
   * @return The person's email
   */
  public String getPersonEmail() {
    return this.person.getEmail();
  }

  /**
   * Gets the current status of this expense.
   *
   * @return The expense status
   */
  public Status getStatus() {
    return this.status;
  }

  /**
   * Gets the timestamp when this expense was created.
   *
   * @return The expense timestamp
   */
  public Instant getTimestamp() {
    return this.timestamp;
  }

  /**
   * Compares this expense with another expense based on timestamp.
   *
   * @param otherExpense The expense to compare with
   * @return A negative integer, zero, or a positive integer as this expense
   *         is earlier than, equal to, or later than the specified expense
   */
  @Override
  public int compareTo(Expense otherExpense) {
    return this.timestamp.compareTo(otherExpense.getTimestamp());
  }

  /**
   * Returns a string representation of this expense.
   * Includes only UUID and status.
   *
   * @return A string representation of the expense
   */
  @Override
  public String toString() {
    return this.uuid + ": " + this.status;
  }

  /**
   * Returns a complete string representation of this expense in CSV format.
   * Includes all expense data separated by commas.
   *
   * @return A comma-separated representation of all expense data
   */
  public String toStringAll() {
    return String.format("%1$s,%2$s,%3$s,%4$s,%5$s,%6$s,%7$s,%8$s,%9$s", uuid, timestamp, value, accountNr, reason, comment, person.getName(), person.getEmail(), status);
  }
}
