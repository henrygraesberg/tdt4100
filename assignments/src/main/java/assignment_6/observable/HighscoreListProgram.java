package assignment_6.observable;

import java.util.Scanner;

public class HighscoreListProgram implements HighscoreListListener {
  private HighscoreList list;
  private Scanner scanner = new Scanner(System.in);

  void init() {
    list = new HighscoreList(5);
    list.addHighscoreListListener(this);
  }

  void run() {
    list.addResult(scanner.nextInt());
  }

  @Override
  public void listChanged(HighscoreList highscoreList, int newScorePosition) {
    System.out.println(String.format("New score was added to position %d", newScorePosition));

    String scores = "";

    for(int i = 0; i < highscoreList.size(); i++) {
      scores += "place " + i + ": " + highscoreList.getElement(i) + ", ";
    }

    System.out.println(scores);
  }

  public static void main(String[] args) {
    HighscoreListProgram program = new HighscoreListProgram();

    program.init();

    for(int i = 0; i < 10; i++) program.run();
  }
}
