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
            this.item = item;
            this.next = next;
        }
    }

    public SLList(int x) {
        head = new IntNode(x, null);
    }

    /** Prepends x*/
    public void addFirst(int x) {
        head = new IntNode(x, head);
    }

    /** Returns the first item in a list */
    public int getFirst() {
        return head.item;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList(10);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.getFirst());
    }

    /* Something to watch out for is not using encapsulation to avoid ...
     * encountering any problems, such as
     *
     * SLList L = new SLList(15);
     * L.addFirst(10);
     * L.first.next.next = L.first.next;
     *
     * The node containing the item 15 ends up pointing to itself &
     * thus messing up the list.
     */
}
