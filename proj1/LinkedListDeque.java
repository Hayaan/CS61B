public class LinkedListDeque<T> {
    private class Node<T> {
        private T data;
        private Node next, prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    private int size = 0;
    private Node sentinel = new Node(null); 

    /* Prepend item to the Linked List, if it's the first. It'll be the sentinel node's next and previous node. */
    public void addFirst(T item) {
        Node first = new Node(item);
        size++;
        
        if (sentinel.next == null) {
            first.next = sentinel;
            first.prev = sentinel;
            sentinel.next = first;
            sentinel.prev = first;
        } else {
            first.next = sentinel.next;
            first.prev = sentinel;
            sentinel.next.prev = first;
            sentinel.next = first;
        }
    }

    /* Append item to the Linked List, if it's the first. It'll be the sentinel node's next and previous node. */
    public void addLast(T item) {
        Node last = new Node(item);
        size++;

        if (sentinel.next == null) {
            last.next = sentinel;
            last.prev = sentinel;
            sentinel.next = last;
            sentinel.prev = last;
        } else {
            last.next = sentinel;
            last.prev = sentinel.prev;
            sentinel.prev.next = last;
            sentinel.prev = last;
        }
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
        return 0;
    }
 
    /* Removes and returns the last item in the Linked List */    
    public T removeLast() {
        return 0;
    }

    /* Get i'th item in the list */
    public T get(int index) {
        return 0;
    }   
}