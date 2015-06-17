import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jmarshall on 6/17/15.
 */
public class Player implements Person {

    private String name;
    private List<Card> hand;
    private double bank;
    private double bet;
    private int points;

    public Player(String name) {
        this();
        this.name = name;
    }

    public Player(){
        hand = new ArrayList<Card>();
        bank = 0.0d;
        bet = 0.0d;
        points = 0;
    }

    public String getName() {
        return name;
    }

    public double getBank() {
        return bank;
    }

    public double getBet() {
        return bet;
    }

    public int getPoints() {
        setScore();
        return points;
    }

    public void setName(String name) {
        this.name = name;
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
        this.bank += this.bet;
    }

    public void loseStandard() {
        this.bank -= this.bet;
        if (bank < 0) {
            this.bank = 0;
        }
    }

    public void doubleDown() {
        this.bet = bet * 2;
    }

    public void winBlackjack() {
        this.bank = ((bet) * (3/2));
    }

    public void addCard(Card c) {
        hand.add(c);
    }

    public void newHand() {
        hand.clear();
        points = 0;
    }

    private void setScore() {
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
        String show = "";
        String nl = "\n";
        for (Card c: hand) {
            show += c.toString() + nl;
        }
        return show;
    }


}
