package Practice;

/**
 * Created by jmarshall on 11/27/15.
 * Assumes key in Linked LIst is an Integer
 */
public class LLOperators {
    public static int max(Node first) {
        Node thisNode = first;
        int max = 0;
        while (thisNode != null) {
            int val = (int) thisNode.item;
            if (val > max) {
                max = val;
            }
            thisNode = thisNode.next;
        }
        return max;
    }

    public static int maxRec(Node first) {
        if (first == null) return 0;
        int val = (int) first.item;
        int max = 0;
        if (max > maxRec(first.next)) {
            max = val;
        }
        return max;
    }
}
