package assignment_1;

public class Digit {
  private int value, base;

  public Digit(int base) {
    this.base = base;
    this.value = 0;
  }
  public Digit(int base, int value) {
    if(value > base || value < 0) throw new IllegalArgumentException("Value must be between 0 and the base system");

    this.value = value;
    this.base = base;
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

  public static void main(String[] args) {
    Digit dig = new Digit(2);
    Digit dig2 = new Digit(16, 11);
    
    System.out.println(dig.increment());
    System.out.println(dig.increment());

    System.out.println(dig);

    System.out.println(dig2);
  }
}
