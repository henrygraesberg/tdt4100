package assignment_1;

public class Tuple<T> {
  public final T x, y;

  public Tuple(T x, T y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return String.format("(%1$s, %2$s)", this.x.toString(), this.y.toString());
  }
}
