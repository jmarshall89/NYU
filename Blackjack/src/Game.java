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
//        decks = gameI.setDecks();
        decks = 2; // todo delete for debugging
//        numPlayers = gameI.setPlayerNumber();
        numPlayers = 2; // todo delete for debugging
//        Now create the players and deck
        dd = new DealerDeck(decks);
//        String name = gameI.setName();
        String name = "Josh"; // todo delete for debugging
        AIPlayers ai = new AIPlayers(numPlayers, name);
        players = ai.getPlayers();


//        Finally the player can set their bankroll
//        players.get(0).setBank(gameI.setBank());
        players.get(0).setBank(100); // todo delete for debugging

//        Now the game logic
        while (gameOn) {

//            Set player bet
//            players.get(0).setBet(gameI.setBet(players.get(0)));
            players.get(0).setBet(10); // todo delete for debugging
            ai.initialDeal(dd);
            game.playerPlay(players.get(0),gameI, dd);
            ai.aiPlay(dd);
            ai.results();

            if (gameI.continueGame(players.get(0))) {
                game.resetGame(players);
                game.resetDealerDeck(players, dd);
            } else {
                gameOn = false;
            }
        }
    }
}
