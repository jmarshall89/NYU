package MoveToFront;

/**
 * Created by jmarshall on 11/28/15.
 */
public class StringParser {
    String string;

    public StringParser(String string) {
        this.string = string;
    }

    public CacheingList<Character> parseString() {
        CacheingList<Character> list = new CacheingList<>();
        for (char c : string.toCharArray()) {
            list.addOrMove(c);
        }
        return list;
    }
}
