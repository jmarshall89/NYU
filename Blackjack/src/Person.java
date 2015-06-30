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
        this.bank = ((bet) * (3/2));
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

    public void winStandard() {
        System.out.println(name + " wins " + bet);
        this.bank += this.bet;
    }

    public void loseStandard() {
        System.out.println(name + " loses " + bet);
        this.bank -= this.bet;
        if (bank < 0) {
            this.bank = 0;
        }
    }

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
            }
        }
        points = score;
    }

    public String showHand() {
        String show = name + " showing: \n";
        String nl = "\n";
        for (Card c: hand) {
            show += c.toString() + nl;
        }
        return show;
    }


    public abstract void hit(DealerDeck dd);

    public abstract void stay();

    public abstract void initialShowing();

    public abstract boolean isBust(int dealerPts);

    public abstract boolean isPush(int dealerPts);

    public abstract boolean playerWin(int dealerPts);

    public abstract boolean isBlackjack();

    public void push() {
        System.out.println("" + name + " pushed with the dealer.");
    }

    public void printBust(String name) {
        System.out.println(name + " busted!");
    }

    public void printWin(String name) {
        System.out.println(name + " wins!");
    }

    public void printLose(String name) {
        System.out.println(name + " loses!");
    }

    public boolean hasAce() {
        for (Card c: hand) {
            if (c.isAce()) {
                return true;
            }
        }
        return false;
    }


}
