import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RunningMedian{
private static Queue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
private static Queue<Integer> maxHeap = new PriorityQueue<>();

public static void adding(int n){
    if(minHeap.isEmpty()){
        minHeap.add(n);
    } else if (maxHeap.size()==minHeap.size()) {
            if(n<maxHeap.peek()){
                minHeap.add(n);
            } else {
                maxHeap.add(n);
                minHeap.add(maxHeap.remove());
            }
    } else if(minHeap.size() > maxHeap.size()) {
            if(n > minHeap.peek()){
                maxHeap.add(n);
            } else {
                minHeap.add(n);
                maxHeap.add(minHeap.remove());
            }
    }
}

public static double median() {
    if(minHeap.isEmpty()){
        return 0;
    } else if(minHeap.size() == maxHeap.size()) {
        return (maxHeap.peek()+minHeap.peek())/2.0;
    } else if (minHeap.size() > maxHeap.size()){
        return minHeap.peek();
    }
    return 0;
}

public static void tracker(int[] a){
    for(int i =0 ;i<a.length;i++){
        adding(a[i]);
        System.out.println(median());
    }
}

public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for(int i =0; i<n;i++){
        a[i]=sc.nextInt();
    }
    tracker(a);
}
}