
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int N;
    private int count;
    private final boolean[][] grid;
    private final WeightedQuickUnionUF wq;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 0) {
            throw new java.lang.IllegalArgumentException("invalid value");
        }
        N = n;
        grid = new boolean[N][N];

        wq = new WeightedQuickUnionUF(N * N + 2);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        count = 0;
    }

    private int map2Dto1D(int row, int col) {
        return row * N + col;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || col < 1 || row > N || col > N) {
            throw new java.lang.IllegalArgumentException("InVaLiD");
        }
        int trow = row - 1;
        int tcol = col - 1;
        int loc = map2Dto1D(trow, tcol);
        if (grid[trow][tcol] == false) {
            count++;
            grid[trow][tcol] = true;
            if (row == 1) {
                wq.union(tcol, N * N);
            }
            if (row == N) {
                wq.union(map2Dto1D(trow, tcol), N * N + 1);
            }
            if (row > 1 && grid[trow - 1][tcol] == true) {
                wq.union(map2Dto1D(trow - 1, tcol), loc);
            }
            if (col > 1 && grid[trow][tcol - 1] == true) {
                wq.union(map2Dto1D(trow, tcol - 1), loc);
            }
            if (row < N && grid[trow + 1][tcol] == true) {
                wq.union(map2Dto1D(trow + 1, tcol), loc);
            }
            if (col < N && grid[trow][tcol + 1] == true) {
                wq.union(map2Dto1D(trow, tcol + 1), loc);
            }

        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || col < 1 || row > N || col > N) {
            throw new java.lang.IllegalArgumentException("Invalid");
        }
        return grid[row - 1][col - 1];
    }


    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || col < 1 || row > N || col > N) {
            throw new java.lang.IllegalArgumentException("Invalid");
        }
        if (wq.find(map2Dto1D(row - 1, col - 1)) == wq.find(N * N)) {
            return true;
        } else {
            return false;
        }
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return count;
    }

    // does the system percolate?
    public boolean percolates() {
        if (wq.find(N * N) == wq.find(N * N + 1)) {
            return true;
        } else {
            return false;
        }
    }

    // test client (optional)


}