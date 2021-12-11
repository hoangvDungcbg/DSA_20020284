import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class SAP {
    private int[] len;
    private int[] iterablelen;
    private Digraph G;

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        this.G = new Digraph(G);
    }

    // do unit testing of this class
    public static void main(String[] args) {
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        len = shortestpath(v, w);
        return len[0];
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        len = shortestpath(v, w);
        return len[1];
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        iterablelen = shortest(v, w);
        return iterablelen[0];
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        iterablelen = shortest(v, w);
        return iterablelen[1];
    }

    //int
    private int[] shortestpath(int v, int w) {
        int[] res = new int[2];
        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(G,v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(G,w);
        int shortestlength = Integer.MAX_VALUE;
        int ancestor = 0;
        for (int i = 0; i < G.V(); i++) {
            if (bfsV.hasPathTo(i) && bfsW.hasPathTo(i)) {
                int temp = bfsV.distTo(i) + bfsW.distTo(i);
                if (temp < shortestlength) {
                    shortestlength = temp;
                    ancestor = i;
                }
            }
        }
        if (shortestlength == Integer.MAX_VALUE) {
            for (int i = 0; i < res.length; i++) {
                res[i] = -1;
            }
            return res;
        }
        res[0] = shortestlength;
        res[1] = ancestor;
        return res;
    }

    //iterable
    private int[] shortest(Iterable<Integer> v, Iterable<Integer> w) {
        int ancestor = 0;
        int shortestlength = Integer.MAX_VALUE;
        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(G,v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(G,w);
        int[] res = new int[2];
        /*for (int n : v)
            for (int m : w) {
                int[] temp = shortestpath(n, m);
                if (temp[0] < shortestlength && temp[0] != -1) {
                    shortestlength = temp[0];
                    ancestor = temp[1];
                }
            }*/
        for (int i = 0; i < G.V(); i++) {
            if (bfsV.hasPathTo(i) && bfsW.hasPathTo(i)) {
                int distance = bfsV.distTo(i) + bfsW.distTo(i);
                if (distance < shortestlength) {
                    shortestlength = distance;
                    ancestor = i;
                }
            }
        }
        if (shortestlength == Integer.MAX_VALUE) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        res[0] = shortestlength;
        res[1] = ancestor;
        return res;
    }

}

class BFS {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    public BFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
    }

    public BFS(Digraph G, Iterable<Integer> s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
    }

    //single source bfs
    private void bfs(Digraph G, int s) {
        Queue<Integer> q = new Queue<Integer>();
        marked[s] = true;
        distTo[s] = 0;
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    //multi source bfs
    private void bfs(Digraph G, Iterable<Integer> sources) {
        Queue<Integer> q = new Queue<Integer>();
        for (int s : sources) {
            marked[s] = true;
            distTo[s] = 0;
            q.enqueue(s);
        }
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }

        }
    }

    public boolean[] getMarked() {
        return this.marked;
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public int distTo(int v) {
        return distTo[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }
}

