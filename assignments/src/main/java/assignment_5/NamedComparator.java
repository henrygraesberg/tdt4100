package assignment_5;

import java.util.Comparator;

public class NamedComparator implements Comparator<Named> {
  @Override
  public int compare(Named n1, Named n2) {
    int comparison = n1.getFamilyName().compareTo(n2.getFamilyName());

    if(comparison == 0)
      comparison = n1.getGivenName().compareTo(n2.getGivenName());

    return comparison;
  }
}
