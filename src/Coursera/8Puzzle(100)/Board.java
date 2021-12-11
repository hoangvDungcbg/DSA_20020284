import edu.princeton.cs.algs4.Stack;

public class Board {
    private int n;
    private int[][] tiles;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] blocks) {
        n = blocks.length;
        tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                tiles[i][j] = blocks[i][j];
            }
    }

    // unit testing (not graded)
    public static void main(String[] args) {
    }

    private static int[][] swapping(int[][] a, int firsti, int firstj, int seci, int secj) {
        int n = a.length;
        int[][] spare = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == seci && j == secj) {
                    spare[i][j] = a[firsti][firstj];
                } else if (i == firsti && j == firstj) {
                    spare[i][j] = a[seci][secj];
                } else {
                    spare[i][j] = a[i][j];
                }
            }
        }
        return spare;
    }

    // string representation of this board
    public String toString() {
        {
            StringBuilder s = new StringBuilder();
            s.append(n + "\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    s.append(String.format("%2d ", tiles[i][j]));
                }
                s.append("\n");
            }
            return s.toString();

        }
    }

    // board dimension n
    public int dimension() {
        return n;
    }

    // number of tiles out of place
    public int hamming() {
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int current = tiles[i][j];
                if (current == 0) continue;
                int correctpos = i * n + j + 1;
                if (current != correctpos) {
                    count++;
                }
            }
        return count;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int sum = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] == 0) continue;
                sum += Math.abs(i - (tiles[i][j] - 1) / n);
                sum += Math.abs(j - (tiles[i][j] - 1) % n);
            }
        return sum;
    }

    // is this board the goal board?
    public boolean isGoal() {
        if (hamming() == 0) {
            return true;
        } else {
            return false;
        }
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) {
            return true;
        }
        if (y == null) {
            return false;
        }
        if (y.getClass() != this.getClass()) {
            return false;
        }
        if (n != ((Board) y).n) {
            return false;
        }
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] != ((Board) y).tiles[i][j])
                    return false;
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Stack<Board> board = new Stack<Board>();
        int zeroi = 0;
        int zeroj = 0;
        loop1:
        for (int i = 0; i < n; i++)
            loop2:for (int j = 0; j < n; j++) {
                if (tiles[i][j] == 0) {
                    zeroi = i;
                    zeroj = j;
                    break loop1;
                }
            }
        if (zeroi > 0) {
            int[][] nb = swapping(tiles, zeroi, zeroj, zeroi - 1, zeroj);
            Board newb = new Board(nb);
            board.push(newb);
        }
        if (zeroi <= n - 2) {
            int[][] nb = swapping(tiles, zeroi, zeroj, zeroi + 1, zeroj);
            Board newb = new Board(nb);
            board.push(newb);
        }
        if (zeroj > 0) {
            int[][] nb = swapping(tiles, zeroi, zeroj, zeroi, zeroj - 1);
            Board newb = new Board(nb);
            board.push(newb);
        }
        if (zeroj <= n - 2) {
            int[][] nb = swapping(tiles, zeroi, zeroj, zeroi, zeroj + 1);
            Board newb = new Board(nb);
            board.push(newb);
        }
        return board;
    }

    private void swap(int[][] a, int i, int j, int x, int y) {
        int temp = a[i][j];
        a[i][j] = a[x][y];
        a[x][y] = temp;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int i = 0, j = 0;
        loop1:
        for (; i < n; i++) {
            j = 0;
            loop2:
            for (; j < n - 1; j++) {
                int a = tiles[i][j];
                int b = tiles[i][j + 1];
                if (a != 0 && b != 0) {
                    break loop1;
                }
            }
        }
        int[][] twin = swapping(tiles, i, j, i, j + 1);
        return new Board(twin);
        //solution for being unable to stop the solver
    }

}