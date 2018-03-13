public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int n) {
        id = new int[n];

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
    public void union (int p, int q) {
        for (int i = 0; i < id.length; i++) {
            // Changing p's value during the iteration would 
            // botch subsequent changes, thus i != p must also be true
            if (id[i] == id[p] && i != p) {
                id[i] = id[q];
            }
        }
        id[p] = id[q];
    }

    public int find(int p) {
        
        return 0;
    }

    public int count() {

        return 0;
    }

}