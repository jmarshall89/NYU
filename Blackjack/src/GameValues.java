import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jmarshall on 6/21/15.
 */
public class GameValues {

    Scanner in = new Scanner(System.in);

    public void getIntro() {

        String intro;
        String nl = "\n";

        intro = "Hello!" + nl + "Welcome to Blackjack!" + nl + nl +
                "Blackjack pays 3 to 2." + nl + "No bet lost on push." + nl + nl;

        System.out.print(intro);
    }

    public List<Person> buildPlayers(String p1name, int numPlayers){
        List<Person> persons = new ArrayList<>();
        persons.add(new Player(p1name));
        for (int i = 0; i < numPlayers; i++) {
            persons.add(new Player("Player " + (i + 2)));
            persons.get(i + 1).setBank(0);
        }
        persons.add(new Dealer());
        return persons;
    }





}
