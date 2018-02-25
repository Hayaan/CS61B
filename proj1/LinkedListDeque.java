public class LinkedListDeque<T> {
    private class Node {
        private T data;
        private Node next, prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    private int size = 0;
    private Node sentinel = Node(0); 

    /* Prepend item to the Linked List, if it's the first. It'll be the sentinel node's next and previous node. */
    public void addFirst(T item) {

    }

    /* Append item to the Linked List, if it's the first. It'll be the sentinel node's next and previous node. */
    public void addLast(T item) {

    }

    /* Return true if empty, false if the List contains any items. */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Returns the # of items in the Deque */
    public int size() {
        return this.size;
    }

    /* Print deque items. Each item will be seperated by a single space. */
    public void printDeque() {

    }

    /* Removes and returns the first item in the Linked List */
    public T removeFirst() {

    }
 
    /* Removes and returns the last item in the Linked List */    
    public T removeLast() {

    }

    /* Get i'th item in the list */
    public T get(int index) {

    }
}