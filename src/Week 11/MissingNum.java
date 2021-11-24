import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */
    //Hash method O(n)
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    // Write your code here
        List<Integer> bk = new ArrayList<Integer>();
        HashSet<Integer> hash = new HashSet<Integer>(brr);
        for(int i: hash) {
            if(Collections.frequency(arr,i) < Collections.frequency(brr,i)){
                bk.add(i);
            }
        }
        Collections.sort(bk);
        return bk;
    }
    //Counting sort method O(n)
    public static List<Integer> missingNumberswithcountingsort(List<Integer> arr, List<Integer> brr) {
        // Write your code here
            List<Integer> ls = new ArrayList<Integer>();
            int[] a = new int[100000];
            for(int i =0 ;i < a.length ;i++){
                a[i] = 0;
            }
            for(int i: arr){
                a[i]--;
            }
            for(int i:brr){
                a[i]++;
            }
            for(int i = 0;i<a.length;i++){
                if(a[i]>0){
                    ls.add(i);
                }
            }
            Collections.sort(ls);
            return ls;
            
    
        }

}

public class MissingNum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }

        List<Integer> result = Result.missingNumbers(arr, brr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
