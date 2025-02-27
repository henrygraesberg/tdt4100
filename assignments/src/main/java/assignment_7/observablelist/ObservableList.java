package assignment_7.observablelist;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;

abstract public class ObservableList {
  private Collection<Object> elements = new ArrayList<Object>();
  private List<ObservableListListener> listeners = new ArrayList<ObservableListListener>();

  public int size() {
    return elements.size();
  }

  public Object getElement(int index) {
    return elements.toArray()[index];
  }

  abstract public boolean acceptsElement(Object object);

  protected void addElement(int index, Object object) {
    if(!this.acceptsElement(object))
      throw new IllegalArgumentException("Cannot add this type of object to the list");
    
    if(index < 0)
      throw new IndexOutOfBoundsException("Illegal index");
    
    ArrayList<Object> arrayList = new ArrayList<Object>(Arrays.asList(this.elements.toArray()));
    arrayList.add(index, object);

    this.elements = arrayList;

    listeners.forEach(listener -> listener.listChanged(this, index));
  }

  protected void addElement(Object object) {
    this.addElement(this.size(), object);
  }

  protected void removeElement(int index) {
    this.removeElementWithoutAlert(index);

    listeners.forEach(listeners -> listeners.listChanged(this, index));
  }

  protected void removeElementWithoutAlert(int index) {
    if(index < 0 || index > this.size() - 1)
      throw new IndexOutOfBoundsException("Illegal index");
    
    ArrayList<Object> arrayList = new ArrayList<Object>(Arrays.asList(this.elements.toArray()));
    arrayList.remove(index);
  
    this.elements = arrayList;    
  }

  public void addObservableListListener(ObservableListListener listener) {
    this.listeners.add(listener);
  }

  public void removeObservableListListener(ObservableListListener listener) {
    this.listeners.remove(listener);
  }

  protected List<ObservableListListener> getListeners() {
    return this.listeners;
  }
}
