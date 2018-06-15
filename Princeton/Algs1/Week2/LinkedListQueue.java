public class LinkedListQueue <T> {
    private Node<T> first, last;
    private int size;

    public LinkedListQueue() {
        size = 0;
    }

    public void enqueue(T item) {
        Node<T> oldLast = last;
        Node<T> last = new Node<>(item);
        oldLast.next = last;
        if (this.isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public T dequeue() {
        T item = first.data;
        first = first.next;
        if (this.isEmpty()) {
            last = null;
        }
        size--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }
}