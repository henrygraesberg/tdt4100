package assignment_2;

public class Vehicle {
  private char vehicleType, fuelType;
  private String registrationNumber;

  public Vehicle(char vehicleType, char fuelType, String registrationNumber) {
    try {
      setVehicleType(vehicleType);
      this.setFuelType(fuelType);
      this.setRegistrationNumber(registrationNumber);
    } catch (Exception e) {
      throw e;
    }
  }

  public char getVehicleType() {
    return this.vehicleType;
  }

  public char getFuelType() {
    return this.fuelType;
  }

  public String getRegistrationNumber() {
    return this.registrationNumber;
  }

  private void setVehicleType(char type) {
    char[] validTypes = {'M', 'C'};

    for (char c : validTypes) {
      if(c == type) {
        this.vehicleType = type;
        return;
      }
    }

    throw new IllegalArgumentException("Vehicle type must be either C or M");
  }

  private void setFuelType(char type) {
    char[] validTypes = {'H', 'E', 'D', 'G'};

    for (char c : validTypes) {
      if(c == type) {
        this.fuelType = type;
        return;
      }
    }

    throw new IllegalArgumentException("Fuel type must be either: H, E, D or G");
  }

  public void setRegistrationNumber(String newRegNumber) {

  }
}
