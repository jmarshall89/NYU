/**
 * Created by jmarshall on 11/28/15.
 */
public class CircularList<Item> {
    private int n;
    private Node first; // what is first in the queue
    private Node last; //what was just added

    public CircularList() {
        n = 0;
        first = null;
        last = first;
    }

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public boolean oneRemaining() {
        return n == 1;
    }

    public void add(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = first; // after the last we want to go back to the first
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    public Item remove(Item item) {
//        First find the node we're removing'
//        Assumption: all items are unique
        Node remove; // using last becasue when we do .next that's the first one
        Node previous;
        previous = findNode(item);
        remove = (previous == null) ? previous : previous.next;
        previous.next = remove.next;
        if (isEmpty()) {
            last = first;
        }
        if (first.item.equals(item)) {
            first = first.next;
        }
        n--;
        return remove.item;
    }

    public Item getFirst() {
        return first.item;
    }

    private Node findNode(Item item) {
        Node remove = last; // using last becasue when we do .next that's the first one
        Node previous = last;
        Item thisItem = null;
        int i = 0;
        while (thisItem != item) {
            previous = remove;
            remove = remove.next;
            thisItem = remove.item;
            if (i++ > n) return null;
        }
        return previous;
    }

    public Item peekNext(Item item) {
        Node previous = findNode(item);
        return previous.next.next.item;
    }
}
