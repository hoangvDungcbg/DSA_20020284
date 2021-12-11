import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final double threshold[];
    private final int trials;
    private double meanVal;
    private double stddevVal;

    /**
     * method.
     */
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();
        this.trials = trials;
        threshold = new double[trials];
        for (int i = 1; i <= trials; i++) {
            Percolation per = new Percolation(n);
            while (per.percolates() == false) {
                int row = StdRandom.uniform(n) + 1;
                int col = StdRandom.uniform(n) + 1;
                per.open(row, col);
            }
            threshold[i - 1] = (double) per.numberOfOpenSites() / (n * n);
        }
        meanVal = StdStats.mean(threshold);
        stddevVal = StdStats.stddev(threshold);
    }

    /**
     * main.
     */
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int T = StdIn.readInt();
        PercolationStats m = new PercolationStats(n, T);
        System.out.println(m.mean());
        System.out.println(m.stddev());
        System.out.println(m.confidenceLo());
        System.out.println(m.confidenceHi());
    }

    public double mean() {
        return meanVal;
    }

    public double stddev() {
        return stddevVal;
    }

    public double confidenceLo() {
        return meanVal - 1.96 * stddevVal / Math.sqrt(trials);
    }

    public double confidenceHi() {
        return meanVal + 1.96 * stddevVal / Math.sqrt(trials);
    }


}