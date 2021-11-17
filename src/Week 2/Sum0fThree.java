import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import java.util.Arrays;

public class Sum0fThree {
    public static void printtriplets(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                    int k=Arrays.binarySearch(a,-(a[i]+a[j]));
                    if(k>j){
                        StdOut.println(a[i]+" "+a[j]+" "+a[k]);
                    }
                }
    }

    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        printtriplets(a);
        double timer1 = timer.elapsedTime();
        StdOut.println("Time:" + timer1);
    }
}
