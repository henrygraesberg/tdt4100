package assignment_6.observable;

import java.util.ArrayList;
import java.util.List;

public class HighscoreList {
  private int maxSize;
  private List<Integer> results = new ArrayList<Integer>(maxSize);
  private List<HighscoreListListener> highscoreListListeners = new ArrayList<HighscoreListListener>();

  public HighscoreList(int maxSize) {
    if(maxSize <= 0) throw new IllegalArgumentException("Max size cannot be 0 or less");

    this.maxSize = maxSize;
  }

  public int size() {
    return this.results.size();
  }

  public int getElement(int index) {
    return this.results.get(index);
  }

  public void addResult(int result) {
    int oldSize = this.results.size();

    if(oldSize == 0) {
      this.results.add(result);
      highscoreListListeners.forEach(listener -> listener.listChanged(this, 0));
      return;
    }

    for (int i = 0; i < oldSize; i++) {
      if(this.results.get(i) > result) {
        this.results.add(i, result);
        final int index = i;
        highscoreListListeners.forEach(listener -> listener.listChanged(this, index));

        break;
      }
    }

    if(this.results.size() == oldSize && !(this.results.size() >= maxSize)) {
      this.results.add(result);
      highscoreListListeners.forEach(listener -> listener.listChanged(this, this.results.size() - 1));
    } else if(this.results.size() == oldSize) {
      highscoreListListeners.forEach(listener -> listener.listChanged(this, -1));
    }

    if(this.results.size() > maxSize) {
      this.results.remove(this.results.size() - 1);
    }
  }

  public void addHighscoreListListener(HighscoreListListener listener) {
    this.highscoreListListeners.add(listener);
  }

  public void removeHighscoreListListener(HighscoreListListener listener) {
    this.highscoreListListeners.remove(listener);
  }
}
