public class Node<Item> {
    public Item data;
    public Node next;

    public Node(Item data) {
        this.data = data;
    }

    public Node(Item data, Node next) {
        this.data = data;
        this.next = next;
    }
}