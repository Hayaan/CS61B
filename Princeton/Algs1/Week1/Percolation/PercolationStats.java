import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] pValues; // pValues.length = T/trials

    public PercolationStats(int n, int trials) {
        if (n < 1 || trials < 1) {
            throw new IllegalArgumentException(
                    "Size of grid or # of trials input was too small.");
        }
        pValues = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation perc = new Percolation(n);
            while (!perc.percolates()) {
            // Open at random site [a, b)
                int randomRow = StdRandom.uniform(1, n + 1);
                int randomCol = StdRandom.uniform(1, n + 1);
                perc.open(randomRow, randomCol);
            }
            pValues[i] = (double) perc.numberOfOpenSites() / (n * n);
        }
    }

    public double mean() {
        // double sum = 0;
        // for (double val : pValues) {
        //     sum += val;
        // }
        // return sum/pValues.length;
        return StdStats.mean(pValues);
    }

    public double stddev() {
        // double resSum = 0;
        // double mean = this.mean();
        // for (double val : pValues) {
        //     resSum += Math.pow((val - mean), 2);
        // }
        // return Math.sqrt(resSum / (pValues.length - 1));
        return StdStats.stddev(pValues);
    }

    public double confidenceLo() {
        double mean = this.mean();
        double stddev = this.stddev();
        return mean - (1.96 * stddev / (Math.sqrt(pValues.length)));
    }

    public double confidenceHi() {
        double mean = this.mean();
        double stddev = this.stddev();
        return mean + (1.96 * stddev / (Math.sqrt(pValues.length)));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats percStat = new PercolationStats(n, t);
        StdOut.println("mean \t\t\t = " + percStat.mean());
        StdOut.println("stddev \t\t\t = " + percStat.stddev());
        StdOut.println("95% confidence interval  = [" +  percStat.confidenceLo() 
            + ", " + percStat.confidenceHi() + "]");        
    }
}