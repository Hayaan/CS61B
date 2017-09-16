public class SLList {
    /* The first item, if it exists, will be @ sentinel.next */
    private IntNode sentinel;

    // Caches the size of the list, so that it doesn't have to be computed every time a user
    // wants to know the size of the list.
    private int size;

    // Nested class
    // Useful for when the class is 'dependent' on the main class.
    private static class IntNode {
        // Doesn't use outside class' instance variables or methods
        // so it can be declared static.
        int item;
        IntNode next;

        IntNode(int i, IntNode n) {
            this.item = i;
            this.next = n;
        }
    }

    /** Creates an empty SLList */
    public SLList() {
        sentinel = new IntNode(63, null);   // any random #, we shouldn't be accesing it anyways.
        size = 0;
    }

    public SLList(int x) {
        sentinel =  new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Prepends x*/
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size ++;
    }

    /** Appends x */
    public void addLast(int x) {
        IntNode current = sentinel;

        while (current.next != null) {
            current = current.next;
        }
        current.next = new IntNode(x, null);
        size++;
    }

    /** Returns the first item in a list */
    public int getFirst() {
        return sentinel.next.item;
    }

    public int getLast() {
        IntNode current = sentinel;
        while (current.next != null) {
            current = current.next;
        }
        return current.item;
    }

    public int size() {
        return size;
    }

    public void print() {
        IntNode current = sentinel;
        while (current.next != null) {
            System.out.println(current.next.item);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList(10);
        L.addFirst(10);
        L.addFirst(5);
        // System.out.println(L.getFirst());
        // System.out.println(L.getLast());
        L.addLast(22);
        // System.out.println(L.getLast());
        L.print();
        System.out.println(L.size());
    }

    /* Something to watch out for is not using encapsulation to avoid ...
     * encountering problems, such as
     *
     * SLList L = new SLList(15);
     * L.addFirst(10);
     * L.first.next.next = L.first.next;
     *
     * The node containing the item 15 ends up pointing to itself &
     * thus messing up the list.
     */
}
