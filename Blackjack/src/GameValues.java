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

    public int getDecks(){
        int decks;
        System.out.print("How many decks would you like to use?  ");
        decks = in.nextInt();

        return decks;
    }

    public int getAiPlayers(){
        int players;
        System.out.print("How many AI players would you like to join?  ");
        players = in.nextInt();

        return players;
    }





}
