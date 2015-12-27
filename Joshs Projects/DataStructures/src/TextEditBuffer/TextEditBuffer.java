package TextEditBuffer;

import Practice.StackLL;

import java.util.Iterator;

/**
 * Created by jmarshall on 12/2/15.
 */
public class TextEditBuffer {
    private StackLL<Character> in = new StackLL<>();
    private StackLL<Character> out = new StackLL<>();

    public void insert(char c) {
        in.push(c);
    }

    public char get() {
        return in.peek();
    }

    public char delete() {
        return in.pop();
    }

    public void left(int k) {
        int i = 0;
        while (i < k) {
            if (in.peek() != null) {
                out.push(in.pop());
            }
            i++;
        }
    }

    public void right(int k) {
        int i = 0;
        while (i < k) {
            if (out.peek() != null) {
                in.push(out.pop());
            }
            i++;
        }
    }

    public int size() {
        int i = 0;
        Iterator<Character> inIt = in.iterator();
        Iterator<Character> outIt = in.iterator();
        while (inIt.hasNext()) {
            i++;
        }
        while (outIt.hasNext()) {
            i++;
        }
        return i;
    }

}