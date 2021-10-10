import java.util.Stack;
class BalancedBrackets{
public static String isBalanced(String s) {
    // Write your code here
        Stack<Character> st=new Stack<>();
        for(int i=0 ;i<s.length();i++){
            char a=s.charAt(i);
            if(a == '(' || a == '[' || a == '{'){
                st.push(a);
            }
            else {
            if(st.isEmpty()){
                return "NO";
            }
            else {
                if(a == ')' && st.pop() != '('){
                    return "NO";
                }
                if(a == ']' && st.pop() != '['){
                    return "NO";
                }
                if(a == '}' && st.pop() != '{'){
                    return "NO";
                }
            }
        }
        
    }
    if(st.isEmpty()){
            return "YES";
        }
        else {
            return "NO";
        }
 }

 public static void main(String[] args){}
}