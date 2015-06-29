import java.util.ArrayList;
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
        List<Person> players = new ArrayList<>();
        PlayerInputs gameI = new PlayerInputs();
        GameValues game = new GameValues();

//        First we need to set up the game
//        Game on!
        gameOn = true;
        game.getIntro();
        decks = gameI.setDecks();
        numPlayers = gameI.setPlayerNumber();

//        Now create the players and deck
        dd = new DealerDeck(decks);
        String name = gameI.setName();
        players = game.buildPlayers(name, numPlayers);

//        Finally the player can set their bankroll
        players.get(0).setBank(gameI.setBank());
        System.out.println(players.get(0).getBank());





    }



}
