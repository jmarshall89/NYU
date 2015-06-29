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
        AIPlayers ai = new AIPlayers(numPlayers, name);
        players = ai.getPlayers();

//        Finally the player can set their bankroll
        players.get(0).setBank(gameI.setBank());

//        Now the game logic
        while (gameOn) {

//            Set player bet
            players.get(0).setBet(gameI.setBet(players.get(0).getName()));
            ai.initialDeal(dd);
            gameOn = false;



        }




    }



}
