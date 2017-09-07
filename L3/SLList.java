public class SLList {
    class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = value;
            this.next = next;
        }
    }

    public IntNode head;

    public SLList(int x) {
        head = new IntNode(x, null);
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList(10);
    }
}
