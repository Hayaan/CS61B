public class QuickUnionUF {
    private int[] id;
    private int count;

    public QuickUnionUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    
    // Helper method of connected & findRoot. Recursively travels up the tree to the root node.
    // Returns the root node's value for eventual comparison.
    public int findRoot(int p) {
        if (id[p] == p) {
            return p;
        } else {
            return findRoot(id[p]);
        }
    }

    // Compares the root nodes of both nodes to see whether or not they're connected
    public boolean connected(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        return pRoot == qRoot;
    }

    // Add connection between p and q, by making p the root of q.
    // id[q] = p
    public void union(int p, int q) {
        id [q] = p;
        count--;
    }

    public int count() {
        return count;
    }

    // Returns the component's root.
    public int find(int p) {
        return findRoot(p);
    }
}