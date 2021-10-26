
import java.util.List;

public class introTutorial{
public static int introTutorial(int V, List<Integer> arr) {

    // Write your code here
    
        int n=arr.size();
        int low = 0;
        int high =n-1;
        while(low <= high){
            int mid = (high+low)/2;
            if(arr.get(mid) == V){
                return mid;
            }
            else if(arr.get(mid)>V){
                high-=1;
            } else{
                low+=1;
            }
        }
        return -1;
    }
}