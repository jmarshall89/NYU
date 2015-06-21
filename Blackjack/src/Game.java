import java.util.List;

/**
 * Created by jmarshall on 6/21/15.
 * This is the actual game logic
 */
public class Game {

    public static void main(String[] args) {

        boolean gameOn;
        int numPlayers;
        int decks;
        DealerDeck dd;
        List<Person> players;
        GameValues game = new GameValues();

//        First we need to set up the game
//        Game on!
        gameOn = true;
        game.getIntro();
        decks = game.getDecks();
        numPlayers = game.getAiPlayers();

//        Now create the players and deck
        dd = new DealerDeck(decks);





    }



}
