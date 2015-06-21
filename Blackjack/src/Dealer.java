import java.util.List;
import java.util.ArrayList;

/**
 * Created by jmarshall on 6/18/15.
 */
public class Dealer extends Person {

    public Dealer() {
        super("Dealer");
    }

    private static final int hitOn = 16;

    public void hit(DealerDeck dd) {
        while (getPoints() <= hitOn) {
            addCard(dd.draw());
        }
    }

    public String dealerShowing() {
        List<Card> hand = getHand();
        String s = "Dealer Showing: " + hand.get(0);
        return s;
    }

    public String dealerCardCount() {
        List<Card> hand = getHand();
        String s = "Dealer Showing: " + hand.get(0) + "\n" +
                   "Dealer has " + hand.size() + " cards.";
        return s;
    }

}
