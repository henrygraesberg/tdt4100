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
    return base;
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
}
