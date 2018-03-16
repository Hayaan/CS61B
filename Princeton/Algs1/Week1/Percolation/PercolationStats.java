import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] thresholdValues;

    public PercolationStats(int n, int trials) {
        int counter = 0;
        thresholdValues = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation perc = new Percolation(n);
            while (!perc.percolates()) {
            // Open at random site [a, b)
                perc.open(StdRandom.uniform(1, n + 1), StdRandom.uniform(1, n + 1));
                counter++;
            }
            thresholdValues[i] = (double) perc.numberOfOpenSites() / (n * n);
            StdOut.println(thresholdValues[i]);
        }
    }

    // public double mean() {

    // }

    // public double stddev() {

    // }

    // public double confidenceLo() {

    // }

    // public double confidenceHi() {

    // }

    public static void main(String[] args) {
        PercolationStats percStat = new PercolationStats(20, 1000);
    }
}