package Week3;

import edu.princeton.cs.algs4.StdOut;


public class BinarySearch {
    int Binarysearch(int arr[], int key, int lo, int hi) {
        if (hi >= 1) {
            int mid = (lo + (hi - 1)) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                return Binarysearch(arr, key, mid - 1, hi);
            } else if (arr[mid] < key) {
                return Binarysearch(arr, key, lo, mid + 1);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        BinarySearch ob = new BinarySearch();
        int arr[] = {1, 2, 9, 8, 6, 3, 5};
        int n = arr.length;
        int key = 9;
        int ketqua = ob.Binarysearch(arr,key,0,n-1);
        if (ketqua == -1) {
            StdOut.println("Ko tim thay gia tri");
        } else {
            ketqua += 1;
            StdOut.println("Value location:" + ketqua);
        }

    }
}
