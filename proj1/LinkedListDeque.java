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

    public void addLast(T item) {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {

    }

    public T removeFirst() {

    }

    public T removeLast() {

    }

    public T get(int index) {
        
    }
}