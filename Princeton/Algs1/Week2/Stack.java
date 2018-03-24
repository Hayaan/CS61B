import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Stack {
    int size;
    Node head;

    public Stack() {
        size = 0;
    }    
    public Stack(String item) {
        head = new Node<String>(item);
        size = 1;
    }

    public void push(String item) {
        if (head != null) {
            Node<String> newHead = new Node<>(item, head);
            head = newHead;            
        } else {
            Node<String> newHead = new Node<>(item);
            head = newHead;
        }
        size++;
    }

    public String pop() {
        String item = head.data;
        head = head.next;
        size--;
        return item.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}