package assignment_3;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
  private List<Card> cards = new ArrayList<Card>();

  public CardDeck(int n) {
    if(n < 0)
      throw new IllegalArgumentException("Deck cannot have negative amount of cards");

    char[] suits = {'S', 'H', 'D', 'C'};

    for(int i = 0; i < 4; i++) {
      char suit = suits[i];

      for(int face = 1; face <= n; face++)
        this.cards.add(new Card(suit, face));
    }
  }

  public int getCardCount() {
    return this.cards.size();
  }

  public Card getCard(int n) {
    try {
      return cards.get(n);
    } catch (Exception e) {
      throw new IllegalArgumentException(
        String.format("Card nr. %d does not exist in this deck", n)
      );
    }
  }

  public void shufflePerfectly() {
    int deckSize = this.getCardCount();
    int halfSize = deckSize / 2;

    Card[][] splitDeck = new Card[2][halfSize];
    splitDeck[0] = this.cards.subList(0, halfSize).toArray(new Card[0]);
    splitDeck[1] = this.cards.subList(halfSize, getCardCount()).toArray(new Card[0]);

    this.cards = new ArrayList<Card>();

    for(int i = 0; i < halfSize; i++) {
      this.cards.add(splitDeck[0][i]);
      this.cards.add(splitDeck[1][i]);
    }
  }
}
