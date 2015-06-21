/**
 * Created by jmarshall on 6/17/15.
 */
public class MainTest {
    public static void main(String[] args) {
//        Deck d = new Deck("Deck 1");
        Person p = new Player("Josh");
        Person d = new Dealer();
        DealerDeck dd = new DealerDeck(6);

        System.out.println(dd.cardCount());
        p.hit(dd);
        d.hit(dd);
        System.out.println(d.showHand());
        System.out.println(dd.cardCount());




    }
}
