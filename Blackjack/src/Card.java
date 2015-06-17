import java.util.HashMap;

/**
 * Created by jmarshall on 6/17/15.
 */
public class Card {

    private String suit;
    private String val;
    private static HashMap<String, Integer> pointKey = new HashMap<String, Integer>();

    public Card(String suit, String val) {
        this();
        this.suit = suit;
        this.val = val;
    }

    public Card() {
        createPointKey();
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public boolean isAce(){
        if (val == "Ace") {
            return true;
        } else {
            return false;
        }
    }

    public void createPointKey(){

//        Create a hashmap with the vals and points
        HashMap<String, Integer> tempPointKey = new HashMap<String, Integer>()
        {{
                put("2", 2);
                put("3", 3);
                put("4", 4);
                put("5 ",5);
                put("6", 6);
                put("7", 7);
                put("8", 8);
                put("9", 9);
                put("10", 10);
                put("King", 10);
                put("Jack", 10);
                put("Queen",10);
                put("Ace", 11);
            }};
        this.pointKey = tempPointKey;
    }

    public int getPoints(){

        int points;
        points = pointKey.get(val);
        return points;
    }

    public String toString() {
        return val + " of " + suit;
    }


}


