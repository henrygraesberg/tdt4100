package assignment_1;

public class Tuple<T> {
  private T x, y;

  public Tuple(T x, T y) {
    this.x = x;
    this.y = y;
  }

  public T x() {
    return this.x;
  }

  public T y() {
    return this.y;
  }

  @Override
  public String toString() {
    return String.format("(%1$s, %2$s)", this.x.toString(), this.y.toString());
  }

  public static void main(String[] args) {
    Tuple<Integer> aaa = new Tuple<Integer>(2, 5);

    System.out.println(aaa);
    System.out.println(new Tuple<String>("aaa", "sss"));
  }
}
