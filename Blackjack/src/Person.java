import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmarshall on 6/17/15.
 */
public abstract class Person {

    private String name;
    private List<Card> hand;
    private int points;

    public Person(String name) {
        this();
        this.name = name;
    }

    public Person() {
        hand = new ArrayList<Card>();
        points = 0;
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
        String show = name + "showing: \n";
        String nl = "\n";
        for (Card c: hand) {
            show += c.toString() + nl;
        }
        return show;
    }




}
