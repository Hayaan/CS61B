class Node {
    Node left, right;
    int data;
    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {             // No left child = value not present.
                left = new Node(value);
            } else {
                left.insert(value);         // Recursively call the insert function on the current node's left child.
                                                                                                    }
        } else {
            if (value > data) {
                if (right == null) {        // No right child = value not present.
                    right = new Node(value);
                } else {
                    right.insert(value);    // Recursively call the insert function on the current node's right child.
                }
            }
        }
    }

    public boolean contains(int value) {
        if (data == value) {                // If the root == value, return true.
            return true;
        } else if (value < data) {
            if (left == null) {             // If there is no left child, the value isn't present.
                return false;
            } else {                        // Else, recursively call the contains function on the left node.
                return left.contains(value);
            }
        } else {                            // If there is no right child, the value isn't present.
            if (right == null) {           
                return false;
            } else {                        // Else, recursively call the contains function on the right node.
                return right.contains(value);
            }
        }
    }
}

