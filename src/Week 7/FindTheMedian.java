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



public class FindTheMedian {
    public static int[] swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
    public static int partition(int[] arr, int low, int high){
      
    // pivot
        int pivot = arr[high]; 
      
    // Index of smaller element and
    // indicates the right position
    // of pivot found so far
        int i = (low - 1); 
  
        for(int j = low; j <= high - 1; j++){
          
        // If current element is smaller 
        // than the pivot
            if (arr[j] < pivot) 
            {
              
            // Increment index of 
            // smaller element
                i++; 
                swap(arr, i, j);
            }
        }   
        swap(arr, i + 1, high);
        return (i + 1);
}
    public static int kthSmallest(int[] arr, int low,
                                  int high, int k)
        {
        // find the partition
            int partition = partition(arr, low, high);
 
            // if partition value is equal to the kth position,
            // return value at k.
            if (partition == k - 1)
                return arr[partition];
 
            // if partition value is less than kth position,
            // search right side of the array.
            else if (partition < k - 1)
               return kthSmallest(arr, partition + 1, high, k);
 
            // if partition value is more than kth position,
        // search left side of the array.
             else
               return kthSmallest(arr, low, partition - 1, k);
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int index = partition(arr,0,n/2);
        System.out.println(kthSmallest(arr,0,n-1,n/2+1));
        
        
    }
}
