
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

    public void playerPlay(Person p, PlayerInputs inputs, DealerDeck dd){
        boolean playing;
//        Test for blackjack first
        playing = !p.isBlackjack();
        while (playing) {
            String choice = null;
            boolean error = true;
            while (error) {
                String ch;
                ch = inputs.setAction();
                if (!ch.equals("error")){
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




}
