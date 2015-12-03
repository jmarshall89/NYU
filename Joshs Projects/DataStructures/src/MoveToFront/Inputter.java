package MoveToFront;

import java.util.Scanner;

/**
 * Created by jmarshall on 11/28/15.
 */
public class Inputter {

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string to add to Queue: ");
        String input = scanner.nextLine();
        return input;
    }

}
