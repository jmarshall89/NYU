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
    AILogic ai = new AILogic();
    GameValues gv = new GameValues();

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
                if (p.getName().equals("Josh")){ // todo delete for debugging
                    continue;
                }
                p.addCard(dd.draw());
            }
        }

        gv.showTitle();
        for (Person p: players) {
            p.initialShowing();
        }
        gv.printLineDown();
    }

    public void aiPlay(DealerDeck dd) {
        String action;
        Person dealer = players.get(dealerIndex);

        for (int i = 1; i < players.size() - 1; i++) {
            boolean playing = true;
            while (playing) {
                if (players.get(i).isBust()){
                    playing = false;
                    continue;
                }
                action = ai.aiDecision(players.get(i), dealer);
                playing = gv.playAction(action, players.get(i), dd);
            }
        }
        Person p = players.get(dealerIndex);
        while (p.getPoints() < hitOn) {
            p.hit(dd);
        }
        if (p.isBust()) {
            p.printBust(p.getName());
        }
    }


    public void results(){
        int dealerPts;
        dealerPts = players.get(dealerIndex).getPoints();
        players.get(dealerIndex).showHand();
        for (int i = 0; i < players.size(); i++) {
            Person p = players.get(i);
            System.out.println(p.showHand());
            if (p.isBust() || p.isBlackjack()) {
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
