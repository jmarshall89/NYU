import java.util.List;

/**
 * Created by jmarshall on 6/21/15.
 */
public class GameValues {

    private static String nl = "\n";
    private static String line = "-----------------------------------";

    public void getIntro() {

        String intro;

        intro = "Hello!" + nl + "Welcome to Blackjack!" + nl  + nl +
                "Blackjack pays 3 to 2." + nl + "No bet lost on push." + nl + nl + line + nl;

        System.out.print(intro);
    }

    public void printLineUp() {
        System.out.println(nl + line );
    }

    public void printLineDown() {
        System.out.println(line + nl);
    }

    public void printLineNone() {
        System.out.println(line);
    }

    public void showTitle(){
        String title;
        title = nl + "Players Showing:" + nl + nl + line;
        System.out.println(title);

    }

    public void printDealerPoints(int dPoints){
        String title;
        title = "Dealer points: " + dPoints + nl + "-------";
        System.out.println(title);
    }

    public void doubleDownError() {
        String title;
        title = "You can only Double Down on your first draw." + nl + "Please rechoose your decision.";
        System.out.println(title);
    }

    public void error() {
        String title;
        title = "Error. Please reenter";
        System.out.println(title);
    }

    public void resultsTitle() {
        String title;
        title = nl + line + nl + nl + "RESULTS" + nl + nl + line;
        System.out.println(title);
    }

    public void playerPlay(Person p, PlayerInputs inputs, DealerDeck dd){
        boolean playing;
//        Test for blackjack first
        playing = !p.isBlackjack();
        while (playing) {
            int count = p.getHand().size();
            String choice = null;
            boolean error = true;
            while (error) {
                String ch;
                ch = inputs.setAction();
                if (ch.equals("d") && count > 2) {
                    doubleDownError();
                    error = false;
                } else if (!ch.equals("error")){
                    error();
                    error = false;
                }
                choice = ch;
            }
            playing = playAction(choice, p, dd);
//            Now test for a bust
            if (p.isBust()) {
                playing = false;
            }
        }
    }

    public boolean playAction(String choice, Person p, DealerDeck dd ) {
        switch (choice) {
            case "h":
                p.hit(dd);
                return true;

            case "s":
                p.stay();
                return false;

            case "d":
                p.doubleDown();
                p.hit(dd);
                return false;
        }
        return false;
    }

    public void resetGame(List<Person> players) {
        for (Person p: players) {
            p.resetBet();
            p.newHand();
        }
    }

    public void resetDealerDeck(List<Person> players, DealerDeck dd) {
        int numPlayers = players.size();
        int minCards;
        int cardsPerPerson = 7;
        int cardsLeft = dd.cardCount();

        minCards = (numPlayers * cardsPerPerson);
        if (cardsLeft <= minCards) {
            dd.createDeck();
        }

    }



}
