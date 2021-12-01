import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int connectedCell(List<List<Integer>> matrix) {
    // Write your code here
        int max = 0;
        int n = matrix.size();
        int m = matrix.get(0).size();
        
        for(int i = 0;i<n;i++)
            for(int j =0;j<m;j++){
                if(matrix.get(i).get(j)==1){
                    int[] temp = {0};
                    covered(matrix,i,j,n,m,temp);
                    if(temp[0]>max){
                        max = temp[0];
                    }
                }
            }
        return max;
    }
    
    static void covered(List<List<Integer>> mat, int i, int j,int n,int m , int[] temp){;
        if(i >= n || i < 0 || j >= m || j < 0){
            return;
        }
        
        if(mat.get(i).get(j) == 0){
            return;
        } 
    
        mat.get(i).set(j,0);
        temp[0]++;
        
        covered(mat,i,j+1,n,m,temp);
        covered(mat,i,j-1,n,m,temp);
        covered(mat,i+1,j,n,m,temp);
        covered(mat,i-1,j,n,m,temp);
        covered(mat,i-1,j+1,n,m,temp);
        covered(mat,i+1,j+1,n,m,temp);
        covered(mat,i+1,j-1,n,m,temp);
        covered(mat,i-1,j-1,n,m,temp);
        
    }

}

public class Connected {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
