package assignment_7.train;

import java.util.ArrayList;
import java.util.List;

/**
 * The class {@code Train} represents a train that consists of one or more train
 * cars.
 * 
 * @see TrainCar
 * @see CargoCar
 * @see PassengerCar
 */
public class Train {
  protected List<TrainCar> trainCars = new ArrayList<TrainCar>();

  /**
   * @param trainCar the train car to check for
   * @return {@code true} if the train contains the train car, {@code false}
   *         otherwise
   * 
   * @see TrainTest#testAddCarToTrain()
   */
  public boolean contains(TrainCar trainCar) {
    return trainCars.contains(trainCar);
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
    if(trainCar == null)
      throw new IllegalArgumentException("Cannot add a null train car");

    trainCars.add(trainCar);
  }

  /**
   * @return the sum of the total weight of all the train cars in the train. There
   *         is no need to
   *         take the weight of the locomotive into account
   * 
   * @see TrainTest#testTotalTrainWeight()
   */
  public int getTotalWeight() {
    return trainCars.stream().mapToInt(car -> car.getTotalWeight()).sum();
  }

  /**
   * @return similar to {@link PassengerCar#getPassengerCount()}, but for the
   *         entire train
   * 
   * @see TrainTest#testPassengerCount()
   */
  public int getPassengerCount() {
    return trainCars.stream()
                      .filter(car -> car instanceof PassengerCar)
                      .mapToInt(car -> ((PassengerCar)car).getPassengerCount())
                      .sum();
  }

  /**
   * @return similar to {@link CargoCar#getCargoWeight()}, but for the entire
   *         train
   * 
   * @see TrainTest#testCargoWeight()
   */
  public int getCargoWeight() {
  return trainCars.stream()
                  .filter(car -> car instanceof CargoCar)
                  .mapToInt(car -> ((CargoCar)car).getCargoWeight())
                  .sum();
  }

  /**
   * @return a string representation of the train. The string should consist of
   *         the
   *         {@link #toString()}s of all train cars in the train
   */
  @Override
  public String toString() {
    List<String> trainCarString = new ArrayList<String>();
    String returnTemplateString = "Total train weight: %1$d, Total passenger count: %2$d, Total cargo weight: %3$d, Train cars: %4$s";

    trainCars.forEach(car -> trainCarString.add(String.format("(%s)", car)));
    
    return String.format(returnTemplateString, this.getTotalWeight(), this.getPassengerCount(), this.getCargoWeight(), trainCarString.toString());
  }

  public static void main(String[] args) {
    Train t = new Train();
    t.addTrainCar(new TrainCar(1000));
    t.addTrainCar(new PassengerCar(1200, 20));
    t.addTrainCar(new PassengerCar(500, 2));
    t.addTrainCar(new CargoCar(1000, 2000));
    t.addTrainCar(new CargoCar(1000, 3500));

    System.out.println(t);

    //Testing without passenger cars and cargo cars to see that no errors occur with
    //the getPassengerCount and getCargoWeight functions if there are no fitting cars
    t = new Train();
    t.addTrainCar(new TrainCar(1000));
    t.addTrainCar(new CargoCar(1000, 2000));
    t.addTrainCar(new CargoCar(1000, 3500));

    System.out.println(t);

    t = new Train();
    t.addTrainCar(new TrainCar(1000));
    t.addTrainCar(new PassengerCar(1200, 20));
    t.addTrainCar(new PassengerCar(500, 2));

    System.out.println(t);
  }
}
