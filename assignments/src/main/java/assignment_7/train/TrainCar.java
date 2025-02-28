package assignment_7.train;

/**
 * The class {@code TrainCar} represents a simple and general train car.
 */
public class TrainCar {

  /**
   * Constructor for a train car.
   * 
   * @param deadWeight the weight of an empty train car
   * @throws IllegalArgumentException if deadWeight is negative
   * 
   * @see TrainCarTest#testDeadWeight()
   */
  public TrainCar(int deadWeight) {
    // TODO: Implement this constructor
  }

  /**
   * @param deadWeight the weight of an empty train car. In other words, the
   *                   weight of only the
   *                   carriage, without passengers and cargo
   * @throws IllegalArgumentException if deadWeight is negative
   * 
   * @see TrainCarTest#testDeadWeight()
   */
  public void setDeadWeight(int deadWeight) {
    // TODO: Implement this method
  }

  /**
   * @return the weight of an empty train car. In other words, the weight of only
   *         the carriage,
   *         without passengers and cargo
   * 
   * @see TrainCarTest#testDeadWeight()
   */
  public int getDeadWeight() {
    // TODO: Implement this method
    return 0;
  }

  /**
   * @return the total weight of the train car. Note that this method should also
   *         be callable on
   *         subclasses and still return the total weight of the train car
   *         (keyword:
   *         redefinition).
   * 
   * @see TrainCarTest#testDeadWeight()
   */
  public int getTotalWeight() {
    // TODO: Implement this method
    return 0;
  }

  /**
   * @return a string representation of the train car. The string should contain
   *         the type of the
   *         train car and the total weight of the train car. For
   *         {@link PassengerCar}, the number
   *         of passengers should also be included. For {@link CargoCar}, the
   *         weight of the cargo
   *         should also be included.
   */
  @Override
  public String toString() {
    // TODO: Implement this method
    return null;
  }

  public static void main(String[] args) {

  }
}
