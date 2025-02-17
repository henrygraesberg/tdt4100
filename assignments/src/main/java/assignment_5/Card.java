package assignment_5;

/**
 * The {@code Card} class is a so-called value-based class, which is coded in such a way that its
 * objects cannot be modified after they are created. A {@code Card} object has a suit and a face.
 */
public class Card implements Comparable<Card> {
    private char suit;
    private int face;

    /**
     * The constructor of the {@code Card} class initializes the suit and face of the card with the
     * first and second arguments, respectively.
     * 
     * @param suit the suit of the card, one of {@code 'S'} (spades), {@code 'H'} (hearts),
     *        {@code 'D'} (diamonds), or {@code 'C'} (clubs)
     * @param face the face of the card, an integer between {@code 1} (ace) and {@code 13} (king)
     *        (both inclusive)
     * @throws IllegalArgumentException if the suit or face is illegal
     * 
     * @see {@link CardTest#testConstructor}
     */
    public Card(char suit, int face) {
        if(!String.valueOf(suit).matches("[SHDC]"))
            throw new IllegalArgumentException("Invalid card suit");
        
        this.suit = suit;

        if(!(face >= 1 && face <= 13))
            throw new IllegalArgumentException("Invalid card face");

        this.face = face;
    }

    /**
     * @return the suit of the card
     */
    public char getSuit() {
        return this.suit;
    }

    /**
     * @return the face of the card
     */
    public int getFace() {
        return this.face;
    }

    /**
     * @return the value of the card of the form {@code <suit><face>}. For example, the ace of
     *         spades should return {@code "S1"}
     * 
     * @see {@link CardTest#testToString}
     */
    @Override
    public String toString() {
        return String.format("%c%d", this.suit, this.face);
    }

    @Override
    public int compareTo(Card card) {
        char[] suitOrder = {'C', 'D', 'H', 'S'};

        int comparison = indexOf(suitOrder, this.getSuit()) - indexOf(suitOrder, card.getSuit());

        if(comparison == 0) {
            comparison = this.getFace() - card.getFace();
        }

        return comparison;
    }

    private int indexOf(char[] array, char character) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == character) return i;
        }

        throw new IllegalArgumentException(String.valueOf(character));
    }
}
