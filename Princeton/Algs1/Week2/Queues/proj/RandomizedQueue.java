import java.util.Iterator;
import java.util.Arrays;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size = 0;
    private Item[] arr = (Item[]) new Object[8];

    public RandomizedQueue() {}

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }

    public void enqueue(Item item) {
        if (item == null) { throw new IllegalArgumentException("Invalid argument."); }
        arr[size++] = item;
        if (size == arr.length) { resize(2.0); }
    }

    public Item dequeue() {
        if (isEmpty()) { throw new NoSuchElementException("Deque is empty"); }
        int i = generateRandomIndex(size);
        Item val = arr[i];
        arr[i] = null;
        size--;
        if (size <= 0.25 * arr.length && arr.length != 8) { resize(0.25f); }
        return val;
    }

    public Item sample() {
        if (isEmpty()) { throw new NoSuchElementException("Deque is empty"); }
        return arr[generateRandomIndex(size)];
    }

    @Override
    public Iterator<Item> iterator() { return new RandomizedQueueIterator(); }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int N = size;
        private Item[] iteratorArray = Arrays.copyOf(arr, size);

        @Override
        public boolean hasNext() { return N > 0; }

        @Override
        public Item next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
            int randomIndex = generateRandomIndex(N--);
            /*
            Swap randomly chosen value from the values not chosen yet,
            and place it beyond the pivot characterised by the index N.
            Any values within the indices N and size have thus already been chosen.
            */
            Item randomValue = iteratorArray[randomIndex];
            iteratorArray[randomIndex] = iteratorArray[N];
            iteratorArray[N] = randomValue;
            return randomValue;
        }
    }

    private void resize(double resizingFactor) {
        Item[] resizedArr = (Item[]) new Object[(int) (resizingFactor * arr.length)];
        for (int i = 0; i < size; i++) {
            resizedArr[i] = arr[i];
        }
        this.arr = resizedArr;
    }

    private int generateRandomIndex(int upperBound) {
        return StdRandom.uniform(upperBound);
    }
}
