import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, int[]arr) {
    // Write your code here
        for(int i=1;i<n;i++){
            int key=arr[i];
            int j=i;
            while(j>=1 && arr[j-1]>key){
                arr[j]=arr[j-1];
                j--;
        }
            arr[j]=key;
            print(arr);
            System.out.println("");
        }
    }
    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
            
        }
    }
}

public class insertionsort2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];        
        for(int i=0;i<n;i++){
            
            arr[i]=sc.nextInt();
        }
        Result.insertionSort2(n, arr);
}
}