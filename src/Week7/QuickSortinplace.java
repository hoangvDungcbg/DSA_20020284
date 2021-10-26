import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QuickSortinplace {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0 ; i<n;i++){
            arr[i]=sc.nextInt();
        }
        quicksort(arr,0,arr.length-1);
        
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int[] arr,int low, int high){
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        for(int x=0;x<arr.length;x++){
            System.out.print(arr[x]+" ");
        }
        System.out.println();
        return i+1;
    }
    public static void quicksort(int[] arr, int low, int high){
        if(low<high){
            int pi = partition(arr,low,high);
            quicksort(arr,low,pi-1);
            quicksort(arr,pi+1,high);
        }
    }
}