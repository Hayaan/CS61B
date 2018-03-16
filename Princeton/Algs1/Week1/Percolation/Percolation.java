import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;
    private int openSites;
    private boolean[][] sites;
    WeightedQuickUnionUF uf;

    // Create a n-by-n grid of blocked sites
    public Percolation(int n) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException("Size of grid is too small.");
        }
        this.n = n;
        // n + 2 to account for the virtual top and bottom nodes
        // index virtual top = n
        // index virtual bottom = n + 1 
        uf = new WeightedQuickUnionUF((n * n) + 2);
        // Store false for closed sites and true for open sites.
        for (int i = 0; i < n; i++) {
            int bottomRowOffset = n * ( n - 1);
            uf.union(n, i); // connect top sites to virtual top
            uf.union(n + 1, bottomRowOffset); // bottom sites to virtual bottom
        }
        sites = new boolean[n][n];
        openSites = 0;
    }

    // Open selected site.
    // row & col = {0, 1, 2, ..., n-2, n-1, n}
    public void open(int row, int col) throws IllegalArgumentException {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("The row or column index was out of bounds.");
        } else if (!sites[row - 1][col - 1]) {
            sites[row - 1][col - 1] = true;
            openSites++;
            int index = (row - 1) * n + (col - 1);
            // System.out.println("Row: " + row + "; Col: " + col + "\nIndex: " + index);
            // If the site is in the leftmost column, we won't be checking any sites to the left of it
            if (!(index % n == 0)) {
                // Connect right side if not in rightmost row
                uf.union(index, index - 1);
            } else if (!(index % n == n - 1)) {
            // Connect left side if not in leftmost row
                uf.union(index, index + 1);
            }
            // If not in the top row, connect to top
            if (!(row == 1)) {
                uf.union(index, index - n);
            } else if (!(row == n)) {
            // If not in the bottom row, connect to bottom.
                uf.union(index, index + n);
            }
        }
    }

    public boolean isOpen(int row, int col) throws IllegalArgumentException {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("The row or column index was out of bounds.");
        }
        return sites[row - 1][col - 1];
    }
    

    public boolean isFull(int row, int col) throws IllegalArgumentException {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("The row or column index was out of bounds.");
        }
        return !sites[row - 1][col - 1];
    }


    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        // Return whether or not the virtual nodes are connected via a 
        // WQUUF connected(virtualTop, virtualBottom) {transitive}
        if (n == 1) {
            return sites[0][0];
        }
        return uf.connected(n, n + 1);
    }


    public static void main(String[] args) {
        Percolation perc = new Percolation(5);
        StdOut.println(perc.numberOfOpenSites());
        StdOut.println(perc.isFull(1, 1));
        StdOut.println(perc.percolates());
        for (int i = 1; i <= 5; i++) {
            perc.open(i, 1);
        }
        StdOut.println(perc.numberOfOpenSites());
        StdOut.println(perc.percolates());
        perc.open(5, 5);

        Percolation newPerc = new Percolation(1);
        StdOut.println(newPerc.percolates());
        newPerc.open(1, 1);
        StdOut.println(newPerc.percolates());
    }
}