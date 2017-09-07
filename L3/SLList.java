public class SLList {
    class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    public IntNode head;

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
}
