import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JesseCookies {
    

        /*
         * Complete the 'cookies' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER k
         *  2. INTEGER_ARRAY A
         */
    
        public static int cookies(int k, List<Integer> A) {
        // Write your code here
                int count = 0;
                PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
                pq.addAll(A);
                while(pq.peek() != null && pq.peek() < k && pq.size() > 1){
                    int smallest = pq.poll();
                    int smaller = pq.poll();
    
                    int sum = smallest + 2* smaller;
                    pq.add(sum);
                    count++;
                }
                    if(pq.peek() == null || pq.peek()<k){
                    return -1;
                }
                    return count;
    
        }
    
    
}
