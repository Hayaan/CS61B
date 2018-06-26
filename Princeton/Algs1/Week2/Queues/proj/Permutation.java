import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        RandomizedQueue<String> randomQueue = new RandomizedQueue<>();
        while (true) {
            try {
                String current = StdIn.readString();
                randomQueue.enqueue(current);
            } catch (NoSuchElementException e) {
                break;
            }
        }
        Iterator<String> it = randomQueue.iterator();
        for (int i = 0; i < n; i++) {
            StdOut.println(it.next());
        }
    }
}
