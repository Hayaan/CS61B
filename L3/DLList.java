public class DLList {
    // Circular sentinel
    // sentinel.next = head; sentinel.prev = tail;
    private IntNode sentinel;
    private int size;

    private class IntNode {
        int data;
        IntNode next;
        IntNode prev;
        
        public IntNode (int num) {
            this.data = num;
        }
    }

    public DLList () {
         this.sentinel = new IntNode(-1);
         this.size = 0;
    }

    public DLList (int num) {
        this.sentinel = new IntNode(-1);
        // Circular sentinel
        sentinel.next = new IntNode(num);
        sentinel.next.prev = sentinel;
        this.size = 1;
    }

    public void addFirst(int num) {
        IntNode newFirst = new IntNode(num);
        newFirst.next = sentinel.next;
        newFirst.prev = sentinel;
        sentinel.next.prev = newFirst;
        sentinel.next = newFirst;
        size++;
    }
    
    public void addLast(int num) {
        sentinel.prev = new IntNode(num, sentinel, sentinel.prev);
        size++;
    }
       
    public int getFirst() {
        return sentinel.next.data; 
    }

    public void print() {
        IntNode current = sentinel;
        while (current.next != null) {
            current = current.next;
            System.out.println(current.data);
        }
    }

    public static void main(String[] args) {
        DLList list = new DLList(5);
        list.addFirst(22);
        list.addFirst(123);
        list.addLast(54);
        list.print();
    }   
}