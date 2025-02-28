package assignment_7.train;

/**
 * One of two different types of train cars, both specialized versions for
 * different purposes. A
 * {@code CargoCar} represents a cargo car that transports various things and
 * stuff.
 * 
 * @see TrainCar
 * @see PassengerCar
 */
public class CargoCar extends TrainCar {
  /**
   * Constructor for the cargo car.
   * 
   * @param deadWeight  the weight of an empty cargo car
   * @param cargoWeight the weight of the cargo in the cargo car
   * @throws IllegalArgumentException if either deadWeight or cargoWeight is
   *                                  negative
   * 
   * @see CargoCarTest#testWeight()
   */
  public CargoCar(int deadWeight, int cargoWeight) {
    super(deadWeight);
    this.setCargoWeight(cargoWeight);

    this.toStringTemplate += ", Cargo weight: %4$d";
  }

  /**
   * @return the weight of the cargo in the cargo car
   * 
   * @see CargoCarTest#testWeight()
   */
  public int getCargoWeight() {
    return this.addedWeight;
  }

  /**
   * @param cargoWeight the weight of the cargo in the cargo car
   * @throws IllegalArgumentException if cargoWeight is negative
   * 
   * @see CargoCarTest#testWeight()
   */
  public void setCargoWeight(int cargoWeight) {
    if(cargoWeight < 0)
      throw new IllegalArgumentException("Cargo weight cannot be negative");
    
    this.addedWeight = cargoWeight;
  }

  @Override
  public String toString() {
    return String.format(toStringTemplate, "Cargo car", this.getDeadWeight(), this.getTotalWeight(), this.getCargoWeight());
  }
}
