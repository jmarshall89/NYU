
/**
 * Created by jmarshall on 6/21/15.
 */
public class GameValues {


    public void getIntro() {

        String intro;
        String nl = "\n";

        intro = "Hello!" + nl + "Welcome to Blackjack!" + nl + nl +
                "Blackjack pays 3 to 2." + nl + "No bet lost on push." + nl + nl;

        System.out.print(intro);
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
            switch (choice) {
                case "h":
                    p.hit(dd);
                    break;
                case "s":
                    p.stay();
                    playing = false;
                    break;
                case "d":
                    p.doubleDown();
                    p.hit(dd);
                    playing = false;
            }

//            Now test for a bust
            if (p.isBust(0)) {
                playing = false;
            }
        }
    }




}
