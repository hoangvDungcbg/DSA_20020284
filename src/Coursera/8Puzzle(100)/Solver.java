import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;


public class Solver {
    private boolean results;
    private int moves;
    private SearchNode solutions;


    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException("Null pointer exception");
        }

        MinPQ<SearchNode> minpq1 = new MinPQ<>();
        MinPQ<SearchNode> minpq2 = new MinPQ<>();
        SearchNode m1 = new SearchNode(initial, 0, null);
        SearchNode m2 = new SearchNode(initial.twin(), 0, null);
        SearchNode node;
        SearchNode twin;

        minpq1.insert(m1);
        minpq2.insert(m2);

        while (!(minpq1.min().board.isGoal() || minpq2.min().board.isGoal())) {

            node = minpq1.delMin();
            twin = minpq2.delMin();

            for (Board board : node.board.neighbors()) {
                if (node.moves == 0 || !board.equals(node.prev.board)) {
                    minpq1.insert(new SearchNode(board, node.moves + 1, node));
                }
            }

            for (Board board : twin.board.neighbors()) {
                if (twin.moves == 0 || !board.equals(twin.prev.board)) {
                    minpq2.insert(new SearchNode(board, twin.moves + 1, twin));
                }
            }

        }
        results = minpq1.min().board.isGoal();
        solutions = minpq1.min();
        moves = minpq1.min().moves;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                blocks[i][j] = in.readInt();
            }
        }
        Board initial = new Board(blocks);

        Solver solver = new Solver(initial);

        if (!solver.isSolvable()) {
            StdOut.println("No solution possible");
        } else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution()) {
                StdOut.println(board);
            }
        }
    }

    public boolean isSolvable() {
        return results;
    }

    public int moves() {
        if (!isSolvable()) {
            return -1;
        }
        return moves;
    }

    public Iterable<Board> solution() {
        if (!isSolvable()) {
            return null;
        }
        Stack<Board> boards = new Stack<>();
        SearchNode node = solutions;
        while (node != null) {
            boards.push(node.board);
            node = node.prev;
        }
        return boards;
    }

    private class SearchNode implements Comparable<SearchNode> {
        Board board;
        SearchNode prev;
        int moves;
        int priority;


        SearchNode(Board board, int moves, SearchNode previous) {
            this.board = board;
            this.moves = moves;
            priority = this.moves + this.board.manhattan();
            this.prev = previous;
        }

        @Override
        public int compareTo(SearchNode that) {
            if (this.priority == that.priority) {
                return 0;
            } else {
                return this.priority - that.priority;
            }
        }
    }
}