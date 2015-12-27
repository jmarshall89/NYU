package Practice;

import java.util.Iterator;

/**
 * Created by jmarshall on 11/26/15.
 */
public class QueueLL<Item> implements Iterable<Item>{
    private int n;
    private Node first; // what is first in the queue
    private Node last; //what was just added

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpyt() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpyt()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpyt()) {
            last = null;
        }
        return item;
    }


    private class ListIterator implements Iterator<Item> {

        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
