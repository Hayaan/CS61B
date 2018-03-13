public class QuickFindUF {
    private int[] id;
    private int count;

    public QuickFindUF(int n) {
        id = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    // If p and q belong to the same component and thus are connected, 
    // they'll share the same id value.
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // Add connection between p and q, by changing any id values
    // in p's component to q's component values
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
        // 2 components --> 1 merged component after the union
        count--;
    }

    // Component identifier for p = {0, 1, 2, ..., n-2, n-1}
    public int find(int p) {
        return id[p];
    }

    public int count() {
        return count;
    }

}