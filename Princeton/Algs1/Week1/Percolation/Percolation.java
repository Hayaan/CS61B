import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] open;
    private boolean[][] full;
    private int n;
    private int openSites;
    private WeightedQuickUnionUF uf;

    public Percolation(int n) throws IllegalArgumentException {
        if (n < 1) {
            throw new IllegalArgumentException("Input for the size of the grid is too small.");
        }
        this.n = n;
        openSites = 0;
        // n by n grid + 2 for the virtual nodes
        uf = new WeightedQuickUnionUF((n * n) + 2);
        open = new boolean[n][n];
        full = new boolean[n][n];
        for (int i = n * n - n; i < n * n; i++) {
            // connect bottom row to virtual bottom site
            uf.union(i, n + 1);
        }
    }

    public void open(int row, int col) throws IllegalArgumentException {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("One of your indices was out of bounds.");
        }
    }

    public void isOpen(int row, int col) throws IllegalArgumentException {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("One of your indices was out of bounds.");
        }
    }

    public void isFull(int row, int col) throws IllegalArgumentException {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("One of your indices was out of bounds.");
        }
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        if (n == 1) {
            return open[1][1];
        }
        // Check whether the top and bottom sites are connected using the transitive property
        return uf.connected(n, n + 1);
    }
}