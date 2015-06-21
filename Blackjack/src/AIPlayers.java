import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmarshall on 6/21/15.
 */
public class AIPlayers {
    private List<Person> players = new ArrayList<Person>;
    private int playerNum = 2;
    private int dealerIndex = 0;

    public AIPlayers(int numPlayers, String p1Name){
//        Add Player
        players.add(new Player(p1Name));
        dealerIndex++;

//        Add AI
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player("Player " + playerNum));
            playerNum++;
            dealerIndex++;
        }

//        Add the dealer
        players.add(new Dealer());
    }

    public List<Person> getPlayers() {
        return players;
    }

    public void initialDeal(DealerDeck dd) {
        for (int i = 0; i < 2; i++){
            for (Person p: players){
                p.addCard(dd.draw());
            }
        }

        for (Person p: players) {
            p.initialShowing();
        }
    }

    public void aiPlay() {
        for (Person 
        }
    }





}
