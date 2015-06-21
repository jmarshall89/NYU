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
        addCard(dd.draw());
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


}
