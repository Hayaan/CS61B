import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

/* 
    Performance requirements.
    Your deque implementation must support each deque operation (including construction)
    in constant worst-case time. A deque containing n items must use at most
    48n + 192 bytes of memory and use space proportional to the number of items currently
    in the deque. Additionally, your iterator implementation must support each operation
    (including construction) in constant worst-case time.
*/

public class Deque<Item>
// implements Iterator<Item> 
{
    private int size = 0;
    private Item[] arr;
    private int headIndex = 4;
    private int tailIndex = 3;

    public Deque() { arr = (Item[]) new Object[8]; }

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }

    public void addFirst(Item item) {
        if (item == null) { throw new IllegalAccessError("Invalid argument."); }
        arr[headIndex] = item;
        updateHead(true);
        size++;
    }

    public void addLast(Item item) {
        if (item == null) { throw new IllegalAccessError("Invalid argument."); }
        arr[tailIndex] = item;
        updateTail(true);
        size++;
    }

    public Item removeFirst() {
        if (arr[headIndex - 1] == null) { throw new NoSuchElementException("Deque is empty"); }
        updateHead(false);
        Item oldFirst = arr[headIndex];
        arr[headIndex] = null;
        size--;
        return oldFirst;
    }

    public Item removeLast() {
        if (arr[tailIndex + 1] == null) { throw new NoSuchElementException("Deque is empty"); }
        updateTail(false);
        Item oldLast = arr[tailIndex];
        arr[tailIndex] = null;  
        size--;
        return oldLast;
    }

    public void printQueue() {
        StdOut.println(Arrays.toString(arr));
        int currentIndex = headIndex;
        StdOut.println("Head: " + headIndex + "\tTail: " + tailIndex);
        
        if (headIndex > tailIndex) {
            while (currentIndex-- != tailIndex + 1) {
                StdOut.println("Value: " + this.arr[currentIndex] + "\tIndex: " + currentIndex);
            }
        } else {
            while (currentIndex != tailIndex + 1) {
                currentIndex = (currentIndex == 0) ? arr.length - 1 : currentIndex - 1;
                StdOut.println("Value: " + this.arr[currentIndex] + "\tIndex: " + currentIndex);
            }
        }
    }

    // public class Iterator<Item> extends Iterator<Item> {
    //     private int i = headIndex;

    //     public boolean hasNext() {
    //         return i >= tailIndex;
    //     }

    //     public Item next() {
    //         return arr[i--];
    //     }
    // }

    private void updateHead(boolean isIncreasing) {
        if (isIncreasing) {
            headIndex = (headIndex == arr.length - 1) ? 0 : headIndex + 1;
        } else {
            headIndex = (headIndex == 0) ? arr.length - 1 : headIndex - 1;
        }
    }

    private void updateTail(boolean isIncreasing) {
        if (isIncreasing) {
            tailIndex = (tailIndex == 0) ? arr.length - Math.abs(tailIndex) : tailIndex - 1;
        } else {
            tailIndex = (tailIndex == arr.length - 1) ? 0 : tailIndex + 1;
        }
    }

    public static void main(String[] args) {
        //UNIT TESTING
        Deque<Integer> headBelowTail = new Deque<>();
        headBelowTail.printQueue();
        headBelowTail.addFirst(5);
        headBelowTail.printQueue();
        headBelowTail.addFirst(2);
        headBelowTail.addFirst(1);
        headBelowTail.printQueue();
        headBelowTail.addFirst(9);
        headBelowTail.printQueue();

        // StdOut.println("Removed head: " + headBelowTail.removeFirst());
        // StdOut.println("Removed tail: " + headBelowTail.removeLast());
        // headBelowTail.addFirst(4);
        // headBelowTail.addFirst(6);
        // headBelowTail.printQueue();

        // StdOut.println();

        // Deque<Integer> tailBelowHead = new Deque<>();
        // tailBelowHead.addLast(2);
        // tailBelowHead.addFirst(5);
        // tailBelowHead.addLast(0);
        // tailBelowHead.addFirst(5);
        // tailBelowHead.printQueue();
        // StdOut.println("Removed head: " + tailBelowHead.removeFirst());
        // StdOut.println("Removed tail: " + tailBelowHead.removeLast());
        // tailBelowHead.printQueue();
    }
}
