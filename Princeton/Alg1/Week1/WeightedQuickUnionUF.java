import java.util.Arrays;

public class WeightedQuickUnionUF {
    private int[] id;
    public int[] size;
    private int count;

    public WeightedQuickUnionUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        size = new int[n];
        Arrays.fill(size, 1);
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

    // Add connection between p and q, by making the root of p the root of q's root.
    // id[root of q] = root of p
    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if (pRoot == qRoot) {
            return;
        } else if (size[pRoot] >= size[pRoot]) {
            id[qRoot] = id[pRoot];
            size[pRoot] += size[qRoot];
        } else {
            id[pRoot] = id[qRoot];
            size[qRoot] = size[pRoot];
        }
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