package Practice;

import java.util.Iterator;

/**
 * Created by jmarshall on 11/28/15.
 */
public class Josephus {
    int numberOfPeople;
    int interval;
    CircularList<Integer> people;
    QueueLL<Integer> executed;

    public Josephus(int numberOfPeople, int interval) {
        this.numberOfPeople = numberOfPeople;
        this.interval = interval;
        if (interval > numberOfPeople) {
            this.interval = numberOfPeople - 1;
        }
        people = new CircularList<>();
        this.executed = new QueueLL<>();
        init();
    }

    private void init() {
        for (int i = 0; i < numberOfPeople; i++) {
            people.add(i);
        }
    }

    public void execute() {
        int remainder = 0;
        int survivor = remainder;
        while (!people.oneRemaining()) {
            remainder = move(survivor, interval);
            survivor = move(remainder, 2);
            people.remove(remainder);
            executed.enqueue(remainder);
        }
    }

    public void printDead() {
        Iterator<Integer> executedInt = executed.iterator();
        while (executedInt.hasNext()) {
            System.out.print(executedInt.next() + " ");
        }
        System.out.print("\n");

    }

    public void printSurvivor() {
        System.out.print("Survivor: " + people.getFirst());
    }

    private int move(int remainder, int interval) {
        int temp = remainder;
        for (int i = 0; i < interval - 1; i++) {
            temp = people.peekNext(temp);
        }
        return temp;

    }


}
