public class ArrayQueue <T> {
    private int size;
    private T[] data;

    public ArrayQueue() {
        size = 0;
        data = (T[]) new Object[8];
    }

    public void enqueue(T item) {

    }

    public T dequeue() {

    }

    public boolean isEmpty() {

    }

    public int size() {

    }

    private void resize (int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = data[i];
        }
        data = copy;
    }
}