package assignment_1;

public class Digit {
  private int value, base;

  public Digit(int base) {
    this.base = base;
    this.value = 0;
  }

  public int getValue() {
    return this.value;
  }

  public int getBase() {
    return this.base;
  }

  public boolean increment() {
    this.value = this.value + 1 >= this.base ? 0 : this.value + 1;

    return this.value == 0;
  }

  @Override
  public String toString() {
    if(this.value < 10) return String.valueOf(this.value);

    String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    
    int rest = this.value - 10;

    return alphabet[rest];
  }

  public static void main(String[] args) {
    Digit digit1 = new Digit(10);

    System.out.println("Digit 1:");
    System.out.println(String.format("increment() => %b", digit1.increment()));
    System.out.println(String.format("getValue() => %d\n", digit1.getValue()));

    Digit digit2 = new Digit(12);

    System.out.println("Digit 2:");
    System.out.println(String.format("getBase() => %d\n", digit2.getBase()));

    for(int i = 0; i < 11; i++) {
      System.out.println(String.format("increment() => %b", digit2.increment()));
    }
    System.out.println();
    
    System.out.println(String.format("getValue() => %d", digit2.getValue()));
    System.out.println(String.format("toString() => %s\n", digit2));

    System.out.println(String.format("increment() => %b", digit2.increment()));
    System.out.println(String.format("toString() => %s", digit2));
  }
}
