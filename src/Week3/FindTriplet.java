import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

class FindTriplet {


    void find3Numbers(int A[], int arr_size, int sum)
    {
        int l, r;
        int count=0;

        Arrays.sort(A);
        arr_size=A.length;

        for (int i = 0; i < arr_size - 2; i++) {
            l = i + 1;
            r = arr_size - 1;
            while (l < r) {
                if (A[i] + A[l] + A[r] == 0) {
                    System.out.println(A[i] + " " + A[l] + " " + A[r]);
                    count++;
                }
                if (A[i] + A[l] + A[r] < 0) {
                    l++;
                } else {
                    r--;
                }

            }
        }
        StdOut.println(count);
    }




    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        int a_size=a.length;
        FindTriplet triplet=new FindTriplet();
        triplet.find3Numbers(a,a_size,0);
        double timer1 = timer.elapsedTime();
        StdOut.println("Time:" + timer1);
    }
}