import java.util.*;
public class Partition {
       
          static void partition(int[] arr) {
              
                      
        
        ArrayList<Integer> L1 = new ArrayList<Integer>();
        ArrayList<Integer> L2 = new ArrayList<Integer>();
        
        int key = arr[0];
        
        for(int i = 1;i<arr.length;i++) {
            if(arr[i]<=key) {
                L1.add(arr[i]);
            }
            else {
                L2.add(arr[i]);
            }
        }
        
        int j = -1;
        for(int x : L1) {
            arr[++j] = x;
            
        }
        
        arr[++j] = key;
        
        for(int x : L2) {
            arr[++j] = x;
            
        }
        
        printArray(arr);
                    
       }   

 static void printArray(int[] arr) {
         for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] arr = new int[n];
           for(int i=0;i<n;i++){
              arr[i]=in.nextInt(); 
           }
           partition(arr);
       }    
   }
