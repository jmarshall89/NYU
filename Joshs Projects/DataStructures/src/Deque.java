import java.util.Iterator;

/**
 * Created by jmarshall on 11/27/15.
 * Allows for additions and removals from both sides
 */
public class Deque<Item> implements Iterable<Item>{

    private Item item;
    DoubleNode left;
    DoubleNode right;
    int n = 0;

    private class DoubleNode {
        DoubleNode left;
        DoubleNode right;
        Item item;
    }

    public boolean isEmpty() {
        return n <= 0;
    }

    public int size() {
        return n;
    }

//    Adds an item to the left end
    public void pushLeft(Item item) {
        if (left == null) {
            left.item = item;
            right = left;
        } else {
            DoubleNode dn = new DoubleNode();
            dn.item = item;
            dn.right = left;
            left.left = dn;
            left = dn;
        }
        n++;
    }

//    Adds a value ot the right end
    public void pushRight(Item item) {
        if (right == null) {
            right.item = item;
            left = right;
        } else {
            DoubleNode dn = new DoubleNode();
            dn.item = item;
            right.right = dn;
            dn.left = right;
            right = dn;
        }
        n++;
    }

//    removes an item from the left end
    public Item popLeft() {
        if (left == null) {
            return null;
        }
        DoubleNode oldLeft = left;
        if (left.right != null) {
            left = left.right;
            left.left = null;
            oldLeft.left = null;
        } else {
            left = null;
        }
        n--;
        return oldLeft.item;
    }

//    removes an item from the right end
    public Item popRight() {
        if (right == null) {
            return null;
        }
        DoubleNode oldRight = right;
        if (right.left != null) {
            right = right.left;
            right.right = null;
            oldRight.left = null;
        } else {
            right = null;
        }
        n--;
        return oldRight.item;
    }
//    Iterator iterates from left to right;
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private DoubleNode current = left;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.right;
            return item;
        }
    }

    //this isn't part of the API given in the problem, but I still want to practice it!
    public void insertBefore(Item before, Item insert) {
        if (left.item.equals(before)) {
            this.pushLeft(insert);
            return;
        }
        DoubleNode addBefore = getNode(before);
        addBefore(addBefore, item);
    }

    private DoubleNode getNode(Item item) {
        DoubleNode current = left;
        while (current != null) {
            if (current.item.equals(item)) {
                return current;
            }
            current = current.right;
        }
        return null;
    }

    private void addBefore(DoubleNode node, Item item){
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;
        newNode.right = node;
        newNode.left = node.left;
        node.left = newNode;
        n++;
    }

    public void insertAfter(Item after, Item insert) {
        if (right.item.equals(after)) {
            this.pushRight(item);
        }
        DoubleNode newNode = getNode(after);
        addBefore(newNode.right, insert);
    }

    public void remove(Item item) {
        if (left.item.equals(item)) {
            popLeft();
            return;
        }
        if (right.item.equals(item)) {
            popRight();
            return;
        }
        DoubleNode removeThis = getNode(item);
        if (removeThis == null) return;
        DoubleNode onLeft = removeThis.left;
        DoubleNode onRight = removeThis.right;
        onLeft.right = onRight;
        onRight.left = onLeft;
    }
}
