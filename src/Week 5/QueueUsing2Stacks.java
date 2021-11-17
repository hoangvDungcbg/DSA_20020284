import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueueUsing2Stacks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack<Integer> s1= new Stack<Integer>();
        Stack<Integer> s2= new Stack<Integer>();
        Scanner sc= new Scanner(System.in);
        int choice=0;
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            choice=sc.nextInt();
            if(choice == 1){
                s1.push(sc.nextInt());
            } else {
                if(s2.isEmpty()){
                    while(!s1.isEmpty())
                    s2.push(s1.pop());
                }
                if(choice == 2){
                    s2.pop();
                }
                if(choice == 3){
                    System.out.println(s2.peek());
                }
            }
            
        }       
    }
}