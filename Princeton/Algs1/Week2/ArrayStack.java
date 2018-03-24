public class ArrayStack <T> {
    private int size;
    private T[] data;

    public ArrayStack() {
        data = (T[]) new Object[8];
        size = 0;
    }

    public void push(T item) {
        data[size++] = item;
    }

    public T pop() {
        T item = data[size];
        data[size--] = null;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}