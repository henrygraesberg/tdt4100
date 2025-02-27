package assignment_7.observablelist;

import java.util.Scanner;

public class ObservableHighscoreListProgram implements ObservableListListener {
  private ObservableHighscoreList list;
  private Scanner scanner = new Scanner(System.in);

  void init() {
    list = new ObservableHighscoreList(3);
    list.addObservableListListener(this);
  }

  void run() {
    list.addResult(scanner.nextInt());
  }

  @Override
  public void listChanged(ObservableList highscoreList, int newScorePosition) {
    System.out.println(String.format("New score was added to position %d", newScorePosition));

    String scores = "";

    for(int i = 0; i < list.size(); i++) {
      scores += "place " + i + ": " + list.getElement(i) + ", ";
    }

    System.out.println(scores);
  }

  public static void main(String[] args) {
    ObservableHighscoreListProgram program = new ObservableHighscoreListProgram();

    program.init();

    for(int i = 0; i < 10; i++) program.run();
  }
}
