import java.util.Scanner;

/**
 * Created by jmarshall on 6/29/15.
 */
public class PlayerInputs {

    private Scanner sc = new Scanner(System.in);

    public int setDecks(){
        int decks;
        System.out.print("How many decks would you like to use?  ");
        decks = sc.nextInt();

        return decks;
    }

    public int setPlayerNumber(){
        int players;
        System.out.print("How many AI players would you like to join?  ");
        players = sc.nextInt();

        return players;
    }

    public double setBank(){
        print("Enter value of Bank: $");
        return sc.nextDouble();
    }

    public double setBet(Person p){
        double bet = 0;
        boolean invalid = true;
        while (invalid){
            print(p.getName() + ", enter your bet: ");
            bet = sc.nextDouble();
            if (bet < p.getBank()) {
                System.out.println("Error, bet exceeds available funds. Try again.");
            } else {
                invalid = false;
            }
        }
        return bet;

    }

    public String setAction(int p){
        print("Choose your action (points: " + p + "): \n (h)it, (s)tay, (d)ouble down: ");
        String action = sc.next();
        action = action.toLowerCase();

        if (action.equals("h") || action.equals("hit")) {
            return "h";
        } else if (action.equals("s") || action.equals("stay")) {
            return "s";
        } else if (action.equals("d") || action.equals("double") || action.equals("dd")
                || action.equals("double down")) {
            return "d";
        }
        return "error";
    }

    public boolean continueGame(Person p){
        double bank = p.getBank();
        print("Play again? (Bank: $" + bank + "): ");
        String ans = sc.next().toLowerCase();
        if (ans.equals("y") || ans.equals("yes")){
            return true;
        }
        print("Goodbye!");
        return false;
    }

    public String setName() {
        print("Please enter your name: ");
        return sc.next();
    }

    private void print(String s){
        System.out.print(s);
    }

}
