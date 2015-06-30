import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmarshall on 6/21/15.
 */
public class AIPlayers {
    private List<Person> players = new ArrayList<Person>();
    private int playerNum = 2;
    private static int dealerIndex = 0;
    private int hitOn = 16;

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

    public void aiPlay(DealerDeck dd) {
        for (int i = 1; i < players.size(); i++) {
            Person p = players.get(i);
            while (p.getPoints() < hitOn) {
                p.hit(dd);
            }
            if (p.isBust(p.getPoints())) {
                p.printBust(p.getName());
            }
        }
    }

    public void results(){
        int dealerPts;
        dealerPts = players.get(dealerIndex).getPoints();
        players.get(dealerIndex).showHand();
        for (int i = 0; i < players.size(); i++) {
            Person p = players.get(i);
            System.out.println(p.showHand());
            if (p.isBust(p.getPoints()) || p.isBlackjack()) {
                continue;
            } else if (p.isPush(dealerPts)) {
                p.push();
            } else if (p.playerWin(dealerPts)) {
                p.printWin(p.getName());
                p.winStandard();
            } else {
                p.printLose(p.getName());
                p.loseStandard();
            }
        }
    }

    public void resetGame() {
        for (Person p: players) {
            p.resetBet();
            p.newHand();
        }
    }



}
