class Node {
    Node left, right;
    int data;
    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);         // Recursively call the insert function on the current node's left child.
                                                                                                    }
        } else {
            if (value > data) {
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.insert(value);    // Recursively call the insert function on the current node's right child.
                }
            }
        }
    }
}

