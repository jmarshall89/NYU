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
        addCard(dd.draw());
    }

    public void initialShowing() {
        List<Card> hand = getHand();
        String s = "Dealer Showing: " + hand.get(0);
        System.out.println(s);
    }

    @Override
    public boolean isBust() {
        if (getPoints() > 21) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isPush(int dealerPts) {
        return false;
    }

    @Override
    public boolean playerWin(int dealerPts) {
        return false;
    }

    @Override
    public boolean isBlackjack() {
        return false;
    }

    public String dealerCardCount() {
        List<Card> hand = getHand();
        String s = "Dealer Showing: " + hand.get(0) + "\n" +
                   "Dealer has " + hand.size() + " cards.";
        return s;
    }

    @Override
    public void stay() {
        return;
    }
}
