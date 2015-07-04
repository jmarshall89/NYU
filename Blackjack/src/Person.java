import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmarshall on 6/17/15.
 */
public abstract class Person {

    private String name;
    private List<Card> hand;
    private int points;
    private double bank;
    private double bet;

    public Person(String name) {
        this();
        this.name = name;
    }

    public Person() {
        hand = new ArrayList<Card>();
        points = 0;
        bank = 0.0d;
        bet = 0.0d;
    }

    public double getBank() {
        return bank;
    }

    public double getBet() {
        return bet;
    }


    public void doubleDown() {
        this.bet = bet * 2;
    }

    public void winBlackjack() {
        double newBet;
        newBet = ((bet) * 3/2);
        this.bank += newBet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCard(Card c) {
        hand.add(c);
    }

    public int getPoints() {
        setScore();
        return points;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public void setBank(double bank) {
        this.bank = bank;
    }

    public void resetBet(){
        this.bet = 0.0d;
    }

    public abstract void winStandard();

    public abstract void loseStandard();

    public void newHand() {
        hand.clear();
        points = 0;
    }

    void setScore() {
        int score = 0;
        int aceCount = 0;
        for (Card c: hand) {
            score += c.getPoints();
            if (c.isAce()) {
                aceCount++;
            }
        }

        while (aceCount > 0) {
            if (score > 21) {
                score = score - 10;
                aceCount--;
            } else {
                aceCount = 0;
            }
        }
        points = score;
    }

    public void showHand() {
        String show = name + " showing: \n";
        String nl = "\n";
        int points = getPoints();
        for (Card c: hand) {
            show += c.toString() + nl;
        }
        show +="Points: " + points + nl + nl;
        System.out.println(show);
    }


    public abstract void hit(DealerDeck dd);

    public abstract void stay();

    public abstract void initialShowing();

    public abstract boolean isBust();

    public abstract boolean isPush(int dealerPts);

    public abstract boolean playerWin(int dealerPts);

    public abstract boolean isBlackjack();

    public void push() {
        System.out.println("" + name + " pushed with the dealer.");
//        System.out.println("Points: " + getPoints());
    }

    public void printBust(String name) {
        System.out.println(name + " busted!");
//        System.out.println("Points: " + getPoints());
    }



    public abstract void printLose(String name);

    public boolean hasAce() {
        for (Card c: hand) {
            if (c.isAce()) {
                return true;
            }
        }
        return false;
    }

    public abstract void winBlackJackString();

    public abstract void printWin(String name);
}
