package assignment_7.observablelist;

public class ObservableHighscoreList extends ObservableList {
  private int maxSize;

  public ObservableHighscoreList(int maxSize) {
    if(maxSize <= 0) throw new IllegalArgumentException("Max size cannot be 0 or less");

    this.maxSize = maxSize;
  }

  @Override
  public boolean acceptsElement(Object object) {
    return object instanceof Integer;
  }

  public void addResult(int result) {
    int oldSize = this.size();

    if(oldSize == 0) {
      this.addElement(result);
      return;
    }

    for (int i = 0; i < oldSize; i++) {
      if((Integer)this.getElement(i) > result) {
        this.addElement(i, result);
        break;
      }
    }

    if(this.size() == oldSize && !(this.size() >= maxSize)) {
      this.addElement(result);
    } else if(this.size() == oldSize) {
      this.getListeners().forEach(listener -> listener.listChanged(this, -1));
    }

    if(this.size() > maxSize) {
      this.removeElementWithoutAlert(this.size() - 1);
    }
  }
}
