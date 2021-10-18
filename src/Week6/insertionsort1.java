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

    public static void insertionSort1(int n, int[]arr) {
    // Write your code here
        int x=arr[n-1];
        for(int i = n-1;i>=1;i--){
            if(i==0 && arr[0]>=x){
                arr[0]=x;
                print(arr);
                System.out.println("");
            } 
            
            if(x<=arr[i-1]){
                arr[i]=arr[i-1];
                print(arr);
                System.out.println("");
                }
            else if(x>arr[i-1] && x<arr[i+1]){
                arr[i]=x;
                print(arr);
                System.out.println("");
            }
            
        }
    }
    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
            
        }
    }
}

public class insertionsort1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];        
        for(int i=0;i<n;i++){
            
            arr[i]=sc.nextInt();
        }
        Result.insertionSort1(n, arr);
}
}

