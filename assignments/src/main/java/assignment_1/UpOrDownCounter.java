package assignment_1;

public class UpOrDownCounter {
  private int value, end, increment;

  public UpOrDownCounter(int start, int end) {
    if(start == end) throw new IllegalArgumentException("Start and end values cannot be the same");

    this.value = start;
    this.end = end;

    this.increment = start < end ? 1 : -1;
  }

  public int getCounter() {
    return this.value;
  }

  public boolean count() {
    if(this.increment < 0) {
      if(this.value <= this.end) return false;
    } else {
      if(this.value >= this.end) return false;
    }

    value += increment;

    return !(value == end);
  }

  public static void main(String[] args) {
    UpOrDownCounter counter = new UpOrDownCounter(0, 5);

    for(int i = 0; i < 5; i++) {
      System.out.println(counter.count());
      System.out.println(counter.getCounter());
    }

    System.out.println(counter.count());
    System.out.println(counter.getCounter());
  }
}
