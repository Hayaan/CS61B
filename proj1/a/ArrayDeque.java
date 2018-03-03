//TODO  add resize method

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
        nextFirst--;
        size++;
        if (nextFirst == -1) {
            nextFirst = data.length - 1;
        }
    }

    public void addLast(T item) {
        data[nextLast] = item;
        size++;
        nextLast = (nextLast + 1) % data.length;
    }

    public T removeFirst() {
        T removed = null;
        if (size != 0) {
            removed = data[nextFirst + 1];
            data[nextFirst] = null;
            nextFirst++;
        }
        return removed;
    }

    public T removeLast() {
        T removed = null;
        if (size != 0) {
            removed = data[nextLast - 1];
            data[nextLast] = null;
            nextLast--;
        }
        return removed;
    }

    public T get(int index) {
        return data[nextFirst + size];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(data[i + nextFirst + 1] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < 3; i++) {
            test.addFirst(rand.nextInt(101));
            test.addLast(rand.nextInt(101));
        }

        System.out.println(test.size());

        test.printDeque();

    }
}