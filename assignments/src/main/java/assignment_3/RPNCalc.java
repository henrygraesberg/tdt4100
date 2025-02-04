package assignment_3;

import java.util.ArrayList;
import java.util.Stack;

public class RPNCalc {
  private Stack<Double> numbers = new Stack<Double>();

  public RPNCalc() {}

  public double peek(int a) {
    int lastIndex = this.numbers.size() - 1;

    try {
      return this.numbers.elementAt(lastIndex - a);
    } catch (Exception e) {
      return Double.NaN;
    }
  }

  public int getSize() {
    return this.numbers.size();
  }

  public void push(double number) {
    this.numbers.push(number);
  }

  public double pop() {
    if(this.numbers.empty())
      return Double.NaN;

    return this.numbers.pop();
  }

  public void performOperation(char operation) { 
    ArrayList<Double> topValues = new ArrayList<Double>();
    
    if(operation == '+' ||
      operation == '-' ||
      operation == '*' ||
      operation == '/' ||
      operation == '~') {
        if(operation == '~' && this.getSize() == 1) return;

        topValues.add(this.pop());
        topValues.add(this.pop());
      }
    if(operation == '|') {
      topValues.add(this.pop());
    }

    for(int i = 0; i < topValues.size(); i++) {
      if(topValues.get(i) == Double.NaN) {
        topValues.remove(Double.NaN);
        topValues.add(i, 0d);
      }
    }
    
    switch (operation) {
      case '+':
        this.push(topValues.get(1) + topValues.get(0));
        break;
      case '-':
        this.push(topValues.get(1) - topValues.get(0));
        break;
      case '*':
        this.push(topValues.get(1) * topValues.get(0));
        break;
      case '/':
        try {
          this.push(topValues.get(1) / topValues.get(0));
        } catch (Exception e) {
          this.push(Double.NaN);
        }
        break;
      case '~':
        this.push(topValues.get(0));
        this.push(topValues.get(1));
        break;
      case 'p':
        this.push(Math.PI);
        break;
      case 'π':
        this.performOperation('p');
        break;
      case '|':
        this.push(Math.abs(topValues.get(0)));
        break;
      default:
        throw new IllegalArgumentException("Illegal operation");
    }
  }
}
