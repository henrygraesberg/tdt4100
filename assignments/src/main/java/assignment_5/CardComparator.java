package assignment_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CardComparator implements Comparator<Card> {
  private boolean aceIsHighest;
  private Character highestSuit;

  public CardComparator(boolean aceIsHighest, char highestSuit) {
    this.aceIsHighest = aceIsHighest;

    if(!String.valueOf(highestSuit).matches("[SHDC ]"))
      throw new IllegalArgumentException("Invalid card suit");

    this.highestSuit = highestSuit;
  }
  
  @Override
  public int compare(Card c1, Card c2) {
    if(!aceIsHighest && highestSuit == ' ')
      return c1.compareTo(c2);
    
    Character[] suitOrderArray = {'C', 'D', 'H', 'S'};
    ArrayList<Character> suitOrder = new ArrayList<Character>(Arrays.asList(suitOrderArray));

    if(highestSuit != ' ') {
      suitOrder.remove(highestSuit);
      suitOrder.add(highestSuit);
    }

    int comparison = indexOf(suitOrder, c1.getSuit()) - indexOf(suitOrder, c2.getSuit());

    if(comparison == 0) {
      int cardFace1 = c1.getFace();
      int cardFace2 = c2.getFace();

      if(aceIsHighest) {
        cardFace1 = cardFace1 == 1 ? 14 : cardFace1;
        cardFace2 = cardFace2 == 1 ? 14 : cardFace2;
      }

      comparison = cardFace1 - cardFace2;
    }

    return comparison;
  }

  private int indexOf(List<Character> array, Character character) {
    for(int i = 0; i < array.size(); i++) {
        if(array.get(i).equals(character)) return i;
    }

    throw new IllegalArgumentException(String.valueOf(character));
  }
}
