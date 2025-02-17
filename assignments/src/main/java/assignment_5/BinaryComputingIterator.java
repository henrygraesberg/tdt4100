package assignment_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator {
  private Iterator<Double> iterator;

  public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator) {    
    this.iterator = performOperation(iterator1, iterator2, null, null, operator);
  }
  public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator) {
    this.iterator = performOperation(iterator1, iterator2, default1, default2, operator);
  }

  private Iterator<Double> performOperation(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator) {
    ArrayList<Double> newList = new ArrayList<Double>();
    
    if(iterator1 == null || iterator2 == null)
      throw new IllegalArgumentException("Iterator cannot be null");

    if(operator == null)
      throw new IllegalArgumentException("Operator cannot be null");

    while(iterator1.hasNext() || iterator2.hasNext()) {
      Double nextElement1 = null, nextElement2 = null;

      try {
        nextElement1 = iterator1.next();
        nextElement2 = iterator2.next();

        newList.add(operator.apply(nextElement1, nextElement2));
      } catch (Exception e) {
        if(nextElement1 == null) {
          newList.add(operator.apply(default1, nextElement2));
        }
        if(nextElement2 == null) {
          newList.add(operator.apply(nextElement1, default2));
        }
      }
    }

    return newList.iterator();
  }

  public static void main(String[] args) {
    Iterator<Double> iterator1 = List.of(2.0, 3.0).iterator();
    Iterator<Double> iterator2 = List.of(5.0).iterator();

    BinaryOperator<Double> addition = (a, b) -> a + b;

    new BinaryComputingIterator(iterator1, iterator2, addition);
  }
}
