import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import edu.princeton.cs.algs4.Stopwatch;


public class TwoSum {
    public static void printpairs(int[] a){
        int n=a.length;
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            int j=Arrays.binarySearch(a,-a[i]);
            if(j>i){
                StdOut.println(a[i]+" "+a[j]);
            }
        }
    }
    public static void main(String[] args){
        Stopwatch timer=new Stopwatch();
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        printpairs(a);
        double time=timer.elapsedTime();
        StdOut.println("Time:"+time);
    }
}
