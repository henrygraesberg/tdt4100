package assignment_7.train;

/**
 * The class {@code Train} represents a train that consists of one or more train
 * cars.
 * 
 * @see TrainCar
 * @see CargoCar
 * @see PassengerCar
 */
public class Train {

  // TODO: Add fields here

  /**
   * @param trainCar the train car to check for
   * @return {@code true} if the train contains the train car, {@code false}
   *         otherwise
   * 
   * @see TrainTest#testAddCarToTrain()
   */
  public boolean contains(TrainCar trainCar) {
    // TODO: Implement this method
    return false;
  }

  /**
   * Adds a train car to the train.
   * 
   * @param trainCar the train car to add
   * @throws IllegalArgumentException if the train car is {@code null}
   * 
   * @see TrainTest#testAddCarToTrain()
   */
  public void addTrainCar(TrainCar trainCar) {
    // TODO: Implement this method
  }

  /**
   * @return the sum of the total weight of all the train cars in the train. There
   *         is no need to
   *         take the weight of the locomotive into account
   * 
   * @see TrainTest#testTotalTrainWeight()
   */
  public int getTotalWeight() {
    // TODO: Implement this method
    return 0;
  }

  /**
   * @return similar to {@link PassengerCar#getPassengerCount()}, but for the
   *         entire train
   * 
   * @see TrainTest#testPassengerCount()
   */
  public int getPassengerCount() {
    // TODO: Implement this method
    return 0;
  }

  /**
   * @return similar to {@link CargoCar#getCargoWeight()}, but for the entire
   *         train
   * 
   * @see TrainTest#testCargoWeight()
   */
  public int getCargoWeight() {
    // TODO: Implement this method
    return 0;
  }

  /**
   * @return a string representation of the train. The string should consist of
   *         the
   *         {@link #toString()}s of all train cars in the train
   */
  @Override
  public String toString() {
    return null;
  }

  public static void main(String[] args) {
    // TODO: Write a main method to test the class
  }
}
