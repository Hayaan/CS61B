public class SLList {
    // Prevents anything from outside the class from accessing the head.
    // *Encapsulation*
    private IntNode head;

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

    public SLList(int x) {
        head = new IntNode(x, null);
    }

    /** Prepends x*/
    public void addFirst(int x) {
        head = new IntNode(x, head);
    }

    /** Appends x */
    public void addLast(int x) {
      IntNode current = head;
      while (current.next != null) {
          current = current.next;
      }
      current.next = new IntNode(x, null);
    }

    /** Returns the first item in a list */
    public int getFirst() {
        return head.item;
    }

    public int getLast() {
        IntNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.item;
    }

    public int size() {
        int size = 0;
        IntNode current = head;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList(10);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.getFirst());
        System.out.println(L.getLast());
        L.addLast(22);
        System.out.println(L.getLast());
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
