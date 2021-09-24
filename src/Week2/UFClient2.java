import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

public class UFClient2 {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        int x=1;
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.find(p)!=uf.find(q)){
                uf.union(p,q);
            }
            if(uf.count()==1){
                StdOut.println("");
                StdOut.println(x);
            }
            x++;
        }
    StdOut.println("FAILED");
    }
}