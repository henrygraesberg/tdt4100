package assignment_2;

public class Vehicle {
  private char vehicleType, fuelType;
  private String registrationNumber;

  public Vehicle(char vehicleType, char fuelType, String registrationNumber) {
    this.setVehicleType(vehicleType);
    this.setFuelType(fuelType);
    this.setRegistrationNumber(registrationNumber);
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

    if(this.getVehicleType() == 'M' && type == 'H')
      throw new IllegalArgumentException("Motorcycles cannot run on hydrogen");

    for (char c : validTypes) {
      if(c == type) {
        this.fuelType = type;
        return;
      }
    }

    throw new IllegalArgumentException("Fuel type must be either: H, E, D or G");
  }

  public void setRegistrationNumber(String newRegNumber) {
    String letters = newRegNumber.replaceFirst("[a-z0-9]+", "");

    if(letters.length() != 2) {
      if(letters.matches("[A-Z]+"))
        throw new IllegalArgumentException("Registration number must contain two letters at the start");
      else
        throw new IllegalArgumentException("A registration number must not contain special characters");
    }

    switch(this.getFuelType()) {
      case 'E':
        if(!(letters.equals("EL") || letters.equals("EK")))
          throw new IllegalArgumentException("Electric vehicles must have registration numbers starting with either EL or EK");

        break;

      case 'H':
        if(!letters.equals("HY"))
          throw new IllegalArgumentException("Hydrogen vehicles must have registration numbers starting with HY");

        break;

      default:
        switch(letters) {
          case "EL":
            throw new IllegalArgumentException("Fossil fuel vehicles cannot have registration numbers starting with EL");
          case "EK":
            throw new IllegalArgumentException("Fossil fuel vehicles cannot have registration numbers starting with EK");
          case "HY":
            throw new IllegalArgumentException("Fossil fuel vehicles cannot have registration numbers starting with HY");
        }
    }

    if(letters.contains("Æ") || letters.contains("Ø") || letters.contains("Å"))
      throw new IllegalArgumentException("Æ, Ø, or Å cannot be in the registration number");
    
    String numbers = newRegNumber.replaceFirst("[A-Z]+", "");

    switch(this.getVehicleType()) {
      case 'C':
        if(numbers.length() != 5)
          throw new IllegalArgumentException("Cars must have 5 numbers in their registration number");
        break;
      default:
        if(numbers.length() != 4)
          throw new IllegalArgumentException("Motorcycles must have 4 numbers in their registration number");
        break;
    }
    
    this.registrationNumber = newRegNumber;
  }
}
