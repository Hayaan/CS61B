public class ArrayDeque<T> {
    private T[] data;
    private int size, nextFirst, nextLast;

    ArrayDeque() {
        data = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }    
    
    ArrayDeque(T item) {
        data = (T[]) new Object[8];
        data[4]= item;
        size = 1;
        nextFirst = 3;
        nextLast = 5;
    }
    
    /* Prepend item to the Linked List, if it's the first. It'll be the sentinel node's next and previous node. */
    void addFirst(T item) {
        data[nextFirst] = item;
        size++; nextFirst++;
        if (size == data.length) {
            resize();
        }
    }

    /* Append item to the Linked List, if it's the first. It'll be the sentinel node's next and previous node. */
    void addLast(T item) {
        data[nextLast] = item;
        size++; nextLast++;
        if (size == data.length) {
            resize();
        }
    }

    /* Return true if empty, false if the List contains any items. */
    boolean isEmpty() {
        return size == 0;
    }

    /* Returns the # of items in the Deque */
    int size() {
        return this.size;
    }

    /* Prints deque items. Each item will be seperated by a single space. */
    void printDeque() {

    }

    /* Removes and returns the first item in the Linked List */
    T removeFirst() {

    }
 
    /* Removes and returns the last item in the Linked List */    
    T removeLast() {

    }

    /* Get i'th item in the list */
    T get(int index) {

    }

    void resize() {

    }

    public static void main(String[] args) {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        test.printDeque();
        test.addFirst(2);
        System.out.println(test.size());
        
        Random rand = new java.util.Random();
        for (int i = 0; i < 10; i++) {
            test.addFirst(rand.nextInt());
            test.addLast(rand.nextInt());
        }
    
        System.out.println(test.size());
    }
}