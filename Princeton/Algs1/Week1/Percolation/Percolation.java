import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int size;
    private int openSites;
    private boolean[][] sites;
    WeightedQuickUnionUF uf;

    // Create a n-by-n grid of blocked sites
    public Percolation(int n) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalAccessException("Size of grid is too small.");
        }
        size = n;
        // n + 2 to account for the virtual top and bottom nodes
        // index virtual top = n
        // index virtual bottom = n + 1 
        uf = new WeightedQuickUnionUF(n + 2);
        // Store false for closed sites and true for open sites.
        sites = new boolean[n][n];
        openSites = 0;
    }

    // Open selected site.
    // row & col = {0, 1, 2, ..., n-2, n-1, n}
    public void open(int row, int col) throws IllegalArgumentException {
        if (row < 0 || row > n || col < 0 || col > n) {
            throw new IllegalArgumentException("The row or column index was out of bounds.");
        } else if (!sites[row - 1][col - 1]) {
            sites[row - 1][col - 1] = true;
            openSites++;
        }
    }

    public boolean isOpen(int row, int col) throws IllegalArgumentException {
        if (row < 0 || row > size || col < 0 || col > size) {
            throw new IllegalArgumentException("The row or column index was out of bounds.");
        }
        return sites[row - 1][col - 1];
    }
    

    public boolean isFull(int row, int col) throws IllegalArgumentException {
        if (row < 0 || row > size || col < 0 || col > size) {
            throw new IllegalArgumentException("The row or column index was out of bounds.");
        }
        return !sites[row - 1][col - 1];
    }


    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        // Return whether or not the virtual nodes are connected via a 
        // WQUUF connected method call.
        return uf.connected(virtualTop, virtualBottom);
    }


    public static void main(String[] args) {
        
    }
}