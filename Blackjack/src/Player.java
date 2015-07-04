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
            System.out.println(getName() + " busts with " + getPoints() + " points.\n");
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
        int count;
        count = getHand().size();
        if (getPoints() == 21 && count == 2) {
            System.out.println(this.getName() + " -- Blackjack! Player wins 3 to 2!\n");
            return true;
        }
        return false;
    }

    public void initialShowing(){
//        System.out.println("" + getName() + " showing: ");
        showHand();
    }

    @Override
    public void winBlackJackString() {
        double newBet = getBet();
        newBet = newBet * 3;
        newBet = newBet / 2;
        System.out.println(getName() + " Wins $" + newBet);
        System.out.println("Bank increased to: $" + getBank());
    }
    public void printWin(String name) {
        System.out.println(name + " wins!");
//        System.out.println("Points: " + getPoints());
    }

    public void winStandard() {
        System.out.println(getName() + " wins S" + getBet());
        setBank(getBank() + getBet());
    }

    public void printLose(String name) {
        System.out.println(name + " loses!");
    }

    public void loseStandard() {
        System.out.println(getName() + " loses S" + getBet());
        setBank(getBank() - getBet());
        if (getBank() < 0) {
            setBank(0);
            System.out.println("Bank Empty");
        }
    }


}
