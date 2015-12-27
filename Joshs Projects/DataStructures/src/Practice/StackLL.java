package Practice;

import java.util.Iterator;

/**
 * Created by jmarshall on 11/22/15.
 */
public class StackLL<Item> implements Iterable<Item>{
//    A Linked List representation of a stack
    private int n;
    private Node first;

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        Node oldFirst = first;
        if (n > 0) {
            first = first.next;
            --n;
        }
        return oldFirst.item;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Item peek() {
        return first.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
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

        @Override
        public void remove() {}
    }

    private class Node {
        Item item;
        Node next;
    }

}
