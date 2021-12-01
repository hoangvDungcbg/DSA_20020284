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
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
      List<List<Integer>> adj = new ArrayList<>();
      for(int i=0; i<n; i++)
         adj.add(new ArrayList<Integer>());
         
      for(int i=0; i<m; i++)
       addEdge(adj, edges.get(i).get(0)-1, edges.get(i).get(1)-1);
       
      int dist[] = new int[n];
      for(int i=0; i<n; i++)
         dist[i] = Integer.MAX_VALUE;
         
      bfsShortestDist(adj, dist, s-1); 
      
      for(int i=0; i<n; i++)
         if(dist[i] == Integer.MAX_VALUE)dist[i] = -1;
         
      List<Integer> ans = new ArrayList<>();
      for(int i=0; i<n; i++) 
         if(i!=s-1)ans.add(dist[i]);
         
      return ans;   
    }
    
    static void addEdge(List<List<Integer>> adj, int v1, int v2){
       adj.get(v1).add(v2);
       adj.get(v2).add(v1);
    }
    
    static void bfsShortestDist(List<List<Integer>> adj, int dist[], int s){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        dist[s] = 0;
        
        while(q.size()>0){
         int temp = q.poll();
         
         for(int ele : adj.get(temp)){
            if(dist[temp] + 6 < dist[ele]) {
               dist[ele] = dist[temp] + 6;
               q.offer(ele);
            }
         }  
       }  
    }
    

}

public class BFSShortest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.bfs(n, m, edges, s);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
