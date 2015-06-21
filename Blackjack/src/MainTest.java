/**
 * Created by jmarshall on 6/17/15.
 */
public class MainTest {
    public static void main(String[] args) {
//        Deck d = new Deck("Deck 1");
        Player p = new Player("Josh");
        DealerDeck dd = new DealerDeck(6);

//        System.out.println(p.getBank());
        p.addCard(dd.draw());
//        p.addCard(d.drawCard());
        p.setBet(3.0);
        p.setBank(100);
        System.out.println(p.showHand());
        System.out.println(p.getPoints());



    }
}
