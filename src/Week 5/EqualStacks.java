package Week5;
import java.util.*;

public class EqualStacks {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        Stack<Integer> st3 = new Stack<Integer>();
        for(int i=h1.size()-1; i>=0; i--){
          if(st1.isEmpty()){
            int a = h1.get(i);
            st1.push(a);
          }else{
            int a = h1.get(i)+st1.peek();
            st1.push(a);
          }
            
        }
        for(int i=h2.size()-1; i>=0; i--){
          if(st2.isEmpty()){
            int b = h2.get(i);
            st2.push(b);
          }else{
            int b = h2.get(i)+st2.peek();
            st2.push(b);
          }
        }
        for(int i=h3.size()-1; i>=0; i--){
          if(st3.isEmpty()){
            int c = h3.get(i);
            st3.push(c);
          }else{
            int c = h3.get(i)+st3.peek();
            st3.push(c);
          }
        }
        // return st1.pop();
        while(!st1.isEmpty()&&!st2.isEmpty()&&!st3.isEmpty()){
          int stack1Height = st1.peek();
          int stack2Height = st2.peek();
          int stack3Height = st3.peek();
          
          if(stack1Height==stack2Height && stack2Height==stack3Height){
            return st1.peek();
          }
          if(stack1Height>stack2Height||stack1Height>stack3Height){
            st1.pop();
          }else if(stack2Height>stack1Height||stack2Height>stack3Height){
            st2.pop();
          }else if(stack3Height>stack1Height||stack1Height>stack2Height){
            st3.pop();
          }
        }
        return 0;
    
        }
        public static void main(String[] args){}
}
