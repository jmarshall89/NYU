import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmarshall on 6/17/15.
 * Creates a deck of multiple decks
 */
public class DealerDeck {

    private List<Deck> fullDeck;
    private int numDecks;
    private static int deckNum = 0;

    public DealerDeck(int numDecks) {
        this.numDecks = numDecks;
        fullDeck = new ArrayList<Deck>();
        createDeck();
    }

    public DealerDeck() {
        this(5);
    }

    public void createDeck() {
        for (int i = 0; i < numDecks; i++) {
            addDeck();
        }
    }

    public Card draw() {
        Deck d = fullDeck.get(0);
        Card c = d.drawCard();
        if (d.deckEmpty()) {
            removeDeck(0);
            addDeck();
        }
        return c;
    }

    private void removeDeck(int deckIndex) {
        fullDeck.remove(0);
    }

    private void addDeck() {
        fullDeck.add(new Deck("Deck " + deckNum));
        deckNum++;
    }

}
