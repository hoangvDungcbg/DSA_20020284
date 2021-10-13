import java.util.*;

import edu.princeton.cs.algs4.*;

public class SelectionSort {

    void slsort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int tmp = a[min];
            a[min] = a[i];
            a[i] = tmp;

        }
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }

    }

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        SelectionSort sr = new SelectionSort();
        sr.slsort(a);
        long end = System.currentTimeMillis();
        StdOut.println("Time: "+(end-start) + "ms");
    }
}
