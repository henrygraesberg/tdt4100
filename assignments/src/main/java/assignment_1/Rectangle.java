package assignment_1;

import static java.lang.Math.abs;
import java.util.List;
import java.util.Arrays;

public class Rectangle {
  private int x1, y1, x2, y2;

  public Rectangle(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }
  public Rectangle(Tuple<Integer> corner1, Tuple<Integer> corner2) {
    this.x1 = corner1.x;
    this.y1 = corner1.y;
    this.x2 = corner2.x;
    this.y2 = corner2.y;
  }

  public int getMinX() {
    return this.x1 <= this.x2 ? this.x1 : this.x2;
  }

  public int getMinY() {
    return this.y1 <= this.y2 ? this.y1 : this.y2;
  }

  public int getMaxX() {
    return this.x1 >= this.x2 ? this.x1 : this.x2;
  }

  public int getMaxY() {
    return this.y1 >= this.y2 ? this.y1 : this.y2;
  }

  public int getWidth() {
    return abs(this.x1 - this.x2);
  }

  public int getHeight() {
    return abs(this.y1 - this.y2);
  }

  public List<Tuple<Integer>> getCorners() {
    List<Tuple<Integer>> corners = Arrays.asList(
      new Tuple<Integer>(this.getMinX(), this.getMinY()),
      new Tuple<Integer>(this.getMinX(), this.getMaxY()),
      new Tuple<Integer>(this.getMaxX(), this.getMaxY()),
      new Tuple<Integer>(this.getMaxX(), this.getMinY())
    );

    return corners;
  }

  public boolean isEmpty() {
    return this.getHeight() == 0 || this.getWidth() == 0;
  }

  public boolean contains(int x, int y) {
    List<Tuple<Integer>> corners = this.getCorners();

    boolean xInside = corners.get(0).x <= x && x <= corners.get(2).x;
    boolean yInside = corners.get(0).y <= y && y <= corners.get(2).y;

    return xInside && yInside;
  }
  public boolean contains(Tuple<Integer> point) {
    return this.contains(point.x, point.y);
  }
  public boolean contains(Rectangle rect) {
    boolean[] contains = {false, false, false, false};

    List<Tuple<Integer>> corners = rect.getCorners();
    
    for(int i = 0; i < corners.size(); i++) {
      if(this.contains(corners.get(i))) {
        contains[i] = true;
      }
    }

    for (boolean bool : contains) {
      if(!bool) return false;
    }

    return true;
  }

  public boolean add(int x, int y) {
    if(this.contains(x, y)) return false;

    if(x < this.getMinX()) {
      if(this.x1 < this.x2) {
        this.x1 = x;
      } else {
        this.x2 = x;
      }
    } else if(x > this.getMaxX()) {
      if(this.x1 > this.x2) {
        this.x1 = x;
      } else {
        this.x2 = x;
      }
    }

    if(y < this.getMinY()) {
      if(this.y1 < this.y2) {
        this.y1 = y;
      } else {
        this.y2 = y;
      }
    } else if(y > this.getMaxY()) {
      if(this.y1 > this.y2) {
        this.y1 = y;
      } else {
        this.y2 = y;
      }
    }

    return true;
  }
  public boolean add(Tuple<Integer> point) {
    return this.add(point.x, point.y);
  }
  public boolean add(Rectangle rect) {
    if(this.contains(rect)) return false;

    for (Tuple<Integer> point : rect.getCorners()) {
      this.add(point);
    }

    return true;
  }

  public Rectangle union(Rectangle rect) {
    Rectangle copy = new Rectangle(this.x1, this.y1, this.x2, this.y2);

    copy.add(rect);

    return copy;
  }

  public boolean intersects(Rectangle rect) {
    for (Tuple<Integer> point : rect.getCorners()) {
      if(this.contains(point)) return true;
    }

    return false;
  }

  @Override
  public String toString() {
    List<Tuple<Integer>> corners = this.getCorners();

    return String.format(
      "A: %1$s, B: %2$s, C: %3$s, D: %4$s", 
      corners.get(0),
      corners.get(1),
      corners.get(2),
      corners.get(3)
    );
  }
}
