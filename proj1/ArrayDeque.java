public class ArrayDeque<T> {
    private T[] data;
    private int size, nextFirst, nextLast;

    public ArrayDeque() {
        data = (T[]) new Object[8];
        size = 0;
        nextFirst = 4; 
        nextLast = 5;
    }

    public void addFirst(T item) {
        data[nextFirst] = item;
        // TODO:
        nextFirst--;
        // Make sure nextFirst rolls over to data.length once it becomes
        // smaller than 0.
        size++;
        if (size == data.length) {
            resize(size * 2);
        } else if (.25*size <= data.length && data.length > 8) {
            resize((int) (size * 0.5));
        }
    }

    public void addLast(T item) {
        data[nextLast] = item;
        /*  Rolls nextLast over to 0 once the index exceeds
            the bounds of the array */
        nextLast = (nextLast + 1) % (data.length - 1);
        size++;
        if (size == data.length) {
            resize(size * 2);
        } else if (.25*size <= data.length && data.length > 8) {
            resize((int) (size * 0.5));
        }
    }

    public void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];

        if (capacity > data.length) {
            for (int i = 0; i < capacity; i++) {
                temp[i] = data[(nextLast + i) % data.length];
            }
        } else {
            for (int i = 0; i < size; i++) {
                temp[i] = data[nextFirst + i + 1];
            }
        }
        nextFirst = temp.length; 
        nextLast = size;
        data = temp;
    }
}