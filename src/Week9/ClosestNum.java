import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
public class ClosestNum {
    static void merge(int[] arr, int l, int m, int h){
        int n1=m-l+1;
        int n2=h-m;
        int L[] = new int[n1];
        int H[] = new int[n2];
        for(int i =0 ;i < n1;i++){
            L[i]=arr[l+i];
        }
        for(int i = 0;i < n2;i++){
           H[i]=arr[m+i+1];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= H[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = H[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }
        while(j>n2){
            arr[k]=H[j];
            j++;
            k++;
        }
    }
    static void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //khai bao so phan tu?
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt(); //nhap mang
        }
        sort(a,0,a.length-1);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
                int diff;
                diff = Math.abs(a[i+1] - a[i]); // hieu 2 so canh nhau  v1 : diff = -1 v2 : diff = 
             
                if (diff < min) {
                    min = diff;
                }
                //System.out.println(a[i]+" "+a[j]);
            }
        for (int i = 0; i < n-1; i++) {
                if (Math.abs(a[i+1]-a[i]) == min)
                    System.out.println(a[i] + " " + a[i+1]);
            }
        }
}
