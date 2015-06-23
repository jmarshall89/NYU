import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jmarshall on 6/17/15.
 */
public class Player extends Person {

    public Player(String name) {
        this();
    }

    public Player() {
        super();
    }

    public void hit(DealerDeck dd) {
        Card c = dd.draw();
        addCard(c);
        System.out.println("Player " + getName() + " drew a " + c.toString());
    }

    public void stay(){
        String stayString;
        String nl = "\n";

        stayString = "Player " + getName() + " stays." + nl + "Points: " + getPoints()
                     + nl + "Cards showing: " + getHand().toString() + nl;

        System.out.println(stayString);
    }

    public boolean isBust(int dealerPts){
        return (getPoints() > 21);
    }

    public boolean isPush(int dealerPts) {
        return (getPoints() == dealerPts);
    }

    public boolean playerWin(int dealerPts){
        if (isBust(dealerPts)) {
            return true;
        }

        if (getPoints() > dealerPts) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBlackjack() {
        if (getPoints() == 21) {
            System.out.println("Blackjack! Player wins 3 to 2!");
            winBlackjack();
            return true;
        }
        return false;
    }

    public void initialShowing(){
        System.out.println("" + getName() + " showing: ");
        showHand();
    }

}
