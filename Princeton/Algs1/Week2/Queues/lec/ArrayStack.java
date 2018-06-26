public class ArrayStack<T> {
    private int size;
    private T[] data;

    public ArrayStack() {
        data = (T[]) new Object[8];
        size = 0;
    }

    public void push(T item) {
        if (size == data.length) {
            resize(2 * size);
        }
        data[size++] = item;
    }

    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot pop from an empty stack.");
        }
        T item = data[size];
        // Avoid loitering so the garbage collector can reclaim the memory.
        data[size--] = null;
        if (data.length > 8 && data.length * .25 >= size) {
            resize((int) (.5 * data.length));
        }
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize (int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = data[i];
        }
        data = copy;
    }
}
