import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jmarshall on 6/17/15.
 */
public class Deck {

    private static final int deckSize = 52;
    private String deckName;
    private Card[] cardArray;
    private List<Card> cards;
    private String[] values;
    private String[] suits;
//    todo: need best way to get suit and values

    public Deck(String deckName) {
        this.deckName = deckName;
        buildValues();
        buildSuits();
        buildDeck();
        shuffleDeck();
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getDeckName() {
        return deckName;
    }

    private void buildValues() {
//        builds array of card values
        values = new String[] {"2", "3", "4", "5", "6",
                               "7", "8", "9", "10", "Jack",
                               "Queen", "King", "Ace"};
    }

    private void buildSuits() {
//        builds an array of suits
        suits = new String[] {"Hearts", "Clubs", "Diamonds", "Spades"};
    }

    private void buildDeck(){

        cardArray = new Card[deckSize];
        int i = 0;

        for (int j = 0; j < values.length; j++) {
            for (int k = 0; k < suits.length; k++){
                Card temp = new Card(suits[k], values[j]);
                cardArray[i] = temp;
                i++;
            }
        }
    }

    public void shuffleDeck() {
        List tempList = new ArrayList(Arrays.asList(cardArray));
        cards = tempList;
        Collections.shuffle(cards);
    }

    public String toString(){
        String s = "";
        String nl = "\n";

        for (Card x: cards) {
            s += x.toString() + nl;
        }
        return s;
    }

    public Card drawCard() {
        Card c;
        c = cards.get(0);
        cards.remove(0);
        return c;
    }

    public boolean deckEmpty(){
        int count;
        count = cards.size();
        if (count <= 0) {
            return true;
        } else {
            return false;
        }
    }


}
