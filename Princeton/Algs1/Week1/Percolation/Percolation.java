import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {
    private boolean[][] open;
    private int n;
    private int vTop;
    private int vBottom;
    private int openSites;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF full;

    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Input for the size of the grid is too small.");
        }
        this.n = n;
        openSites = 0;
        vTop = 0;
        vBottom = (index(n, n) + 1);

        uf = new WeightedQuickUnionUF(n * n + 2);
        // The full UF won't be connecting to the virtual bottom site
        // to prevent backwash.
        full = new WeightedQuickUnionUF(n * n + 1);
        open = new boolean[n][n];
    }

    // Index 0 is taken by the virtual top site, thus
    // col will be one-based while rows are still zero based when calculating
    // the index.
    // The grid's sites' indices will range from 
    // {1, 2, 3, ..., n - 2, n - 1, n}
    private int index(int row, int col) {
        return (row - 1) * n + col;
    }

    public void open(int row, int col) {
        if ((row < 1) || (row > n) || (col < 1) || (col > n)) {
            throw new IllegalArgumentException("One of your indices was out of bounds.");
        }
        if (!open[row - 1][col - 1]) {
            int index = index(row, col);
            // Open site in boolean arr and increment the # of open sites
            open[(row - 1)][(col - 1)] = true;
            openSites++;
            // If in top row, connect to the virtual top site in both UFs
            if (row == 1) {
                uf.union(index, vTop);
                full.union(index, vTop);
            } else if (open[row - 2][col - 1]) {
            // If not in the top row, connect to the site directly above in both UFs
                uf.union(index, index - n);
                full.union(index, index - n);
            }
            // If in the bottom row, solely connect the site to the bottom virtual site
            // as to prevent backwash.
            if (row == n) {
                uf.union(index, vBottom);
            } else if (open[row][(col - 1)]) {
            // If not in the bottom row, connect to the site directly below in both UFs
                uf.union(index, index + n);
                full.union(index, index + n);
            }
            // Not in leftmost row? Connect to site directly to the left in both UFs
            if (index % n != 1 && open[(row - 1)][(col - 2)]) {
                uf.union(index, index - 1);
                full.union(index, index - 1);
            }
            // Not in rightmost row? Connect to site directly to the right in both UFs
            if (index % n != 0 && open[(row - 1)][col]) {
                uf.union(index, index + 1);
                full.union(index, index + 1);
            }
        }
    }

    public boolean isOpen(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("One of your indices was out of bounds.");
        }
        return open[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        if ((row < 1) || (row > n) || (col < 1) || (col > n)) {
            throw new IllegalArgumentException("One of your indices was out of bounds.");
        } else if (n == 1) {
            return open[0][0];
        }
        return full.connected(index(row, col), vTop);   
    }

    // Return # of open sites in n-by-b grid
    public int numberOfOpenSites() {
        return openSites;
    }

    // Return whether or not the top row is connected to the bottom row.
    // Using a virtual top and bottom site
    public boolean percolates() {
        if (n == 1) {
            return open[0][0];
        }
        return uf.connected(vBottom, vTop);
    }

    public static void main(String[] args) {
        Percolation perc = new Percolation(5);
        StdOut.println(perc.numberOfOpenSites());
        StdOut.println(perc.isFull(1, 1));
        StdOut.println(perc.percolates());
        for (int i = 1; i <= 5; i++) {
            perc.open(i, 1);
            StdOut.println(perc.percolates());
        }
        StdOut.println(perc.numberOfOpenSites());
        StdOut.println(perc.percolates());
        perc.open(5, 5);
    }
}