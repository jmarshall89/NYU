package MoveToFront;

/**
 * Created by jmarshall on 11/28/15.
 */
public class MoveToFrontTest {
    public static void main(String[] args) {
        Inputter inputter = new Inputter();
        String input = inputter.getInput();
        StringParser parser = new StringParser(input);
        CacheingList<Character> cacheingList = parser.parseString();
        cacheingList.print();
    }
}
