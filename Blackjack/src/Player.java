import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jmarshall on 6/17/15.
 */
public class Player extends Person {

    private double bank;
    private double bet;


    public Player(String name) {
        this();
    }

    public Player(){
        super();
        bank = 0.0d;
        bet = 0.0d;
    }

    public double getBank() {
        return bank;
    }

    public double getBet() {
        return bet;
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

    private boolean isBust(int dealerPts){
        return (getPoints() > 21);
    }

    public boolean isPush(int dealerPts) {
        return (getPoints() == dealerPts);
    }

    public boolean playerWin(int dealerPts){
        if (isBust(dealerPts)) {
            return false;
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
