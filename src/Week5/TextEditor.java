package Week5;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TextEditor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack<String> st=new Stack<String>();
        String s="";
        st.push(s);
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n!=0){
            int choice=sc.nextInt();
            switch(choice){
            case 1:             
                s = s + sc.next();
                st.push(s);
                break;
            case 2:
                s=s.substring(0,s.length()-sc.nextInt());
                st.push(s);
                break;
            case 3:              
                System.out.println(s.charAt(sc.nextInt()-1));
                break;
            case 4:
                st.pop();
                s=st.peek();
                break;
            }
            n--;
        }
        }
        
    }

