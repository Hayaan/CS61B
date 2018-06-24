import java.lang.reflect.GenericArrayType;
import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {
    private class Node {
        public Item val;
        public Node next, prev;
        public Node (Item val) { this.val = val; }
        public Node(Item val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private int size;
    private Node sentinel;

    public Deque() {
        sentinel = new Node(null);
        size = 0;
    }

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }

    public void addFirst(Item val) {
        if (val == null) { throw new IllegalArgumentException(); }
        Node newFirst;
        if (isEmpty()) {
            newFirst = new Node(val, sentinel, sentinel);
            sentinel.next = newFirst;
            sentinel.prev = newFirst;
        } else {
            newFirst = new Node(val, sentinel.next, sentinel);
            sentinel.next.prev = newFirst;
            sentinel.next = newFirst;
        }
        size++;
    }

    public void addLast(Item val) {
        if (val == null) { throw new IllegalArgumentException(); }
        Node newLast;
        if (isEmpty()) {
            newLast = new Node(val, sentinel, sentinel);
            sentinel.next = newLast;
            sentinel.prev = newLast;
        } else {
            newLast = new Node(val, sentinel, sentinel.prev);
            sentinel.prev.next = newLast;
            sentinel.prev = newLast;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) { throw new NoSuchElementException(); }
        Item oldFirst = sentinel.next.val;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return oldFirst;
    }

    public Item removeLast() {
        if (isEmpty()) { throw new NoSuchElementException(); }
        Item oldLast = sentinel.prev.val;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return oldLast;
    }

    @Override
    public Iterator<Item> iterator() { return new DequeIterator(); }

    private class DequeIterator implements Iterator<Item> {
        private Node current = sentinel.next;
        
        @Override
        public boolean hasNext() { return current != sentinel && current != null; }

        @Override
        public Item next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
            Item val = current.val;
            current = current.next;
            return val;
        }
    }
}
