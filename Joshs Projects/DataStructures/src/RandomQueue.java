import java.util.Random;

/**
 * Created by jmarshall on 11/27/15.
 */
public class RandomQueue<Item> {

    private int n = 0;
    Item[] a = (Item[]) new Object[1];

    private boolean isEmpty() {
        return n == 0;
    }

    private int size() {
        return n;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    private int randomPosition() {
        Random rand = new Random();
        return rand.nextInt(n+1);

    }

    public void enqueue(Item item) {
        if (n == a.length) {
            resize(2 * a.length);
        }
        a[n++] = item;
    }

    public Item dequeue() {
        int index = randomPosition();
        Item last = a[--n];
        Item rand = a[index];
        a[index] = last;
        a[n] = null;
        if (n >0 && n == a.length/4) {
            resize(a.length/2);
        }
        return rand;
    }

    public Item sample() {
        return a[randomPosition()];
    }


}
