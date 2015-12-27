package Practice;

import java.util.Iterator;

/**
 * Created by jmarshall on 11/26/15.
 */
public class StackClient {

    public static StackLL<String> copy(StackLL<String> old) {
        StackLL<String> newStack = new StackLL<>();
        QueueLL<String> tempQueue = new QueueLL<>();
        Iterator<String> oldIterator = old.iterator();
        while (oldIterator.hasNext()) {
            tempQueue.enqueue(oldIterator.next());
        }
        Iterator<String> queueIterator = tempQueue.iterator();
        while (queueIterator.hasNext()) {
            newStack.push(queueIterator.next());
        }
        return newStack;
    }


}
