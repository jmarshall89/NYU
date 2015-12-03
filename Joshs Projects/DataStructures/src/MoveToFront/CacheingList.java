package MoveToFront;

import java.util.Iterator;

/**
 * Created by jmarshall on 11/28/15.
 */
public class CacheingList<Item> implements Iterable<Item> {

    private int n;
    private Node first;

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void addOrMove(Item item) {
        Node temp = first;
        Node previous = null;
        while (temp != null) {
            if (temp.item.equals(item)) {
                remove(previous);
                break;
            }
            previous = temp;
            temp = temp.next;
        }
        add(item);
    }

    public void print() {
        Iterator<Item> iter = this.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " : ");
        }
    }

    private void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    private void remove(Node node) {
        Node remove = node.next;
        if (remove.next != null) {
            node.next = remove.next;
        } else {
            node.next = null;
        }
    }





    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    //todo make sure this is right
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

    private class Node {
        Item item;
        Node next;
    }



}
