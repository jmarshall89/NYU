import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jmarshall on 6/17/15.
 */
public class Player extends Person {

    public Player(String name) {
        this();
        this.setName(name);
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

        stayString = getName() + " stays." + nl + "Points: " + getPoints()
                     + nl + "Cards showing: " + getHand().toString() + nl;

        System.out.println(stayString);
    }

    public boolean isBust(){
        boolean result = (getPoints() > 21);
        if (result) {
            this.printBust(getName());
            System.out.println(getName() + " busts with " + getPoints() + " points.");
            return true;
        }
        return false;
    }

    public boolean isPush(int dealerPts) {
        return (getPoints() == dealerPts);
    }

    public boolean playerWin(int dealerPts){
        if (isBust()) {
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
            System.out.println(this.getName() + " -- Blackjack! Player wins 3 to 2!\n");
            winBlackjack();
            return true;
        }
        return false;
    }

    public void initialShowing(){
//        System.out.println("" + getName() + " showing: ");
        System.out.println(showHand());
    }

}
