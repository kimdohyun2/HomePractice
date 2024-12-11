package coding_test.dec_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Dohyun4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean asymmetry = true;

        int i = 0;
        while(!(in = br.readLine()).equals(".")){
            for(char c : in.toCharArray()){
                i++;
                if(c == '.'){
                    if(asymmetry && stack.isEmpty()) sb.append("yes\n");
                    else sb.append("no\n");
                    asymmetry = true;
                    i=0;
                    stack.clear();
                    break;
                }
                switch(c) {
                    case '(', '[':
                        stack.push(c);
                        break;
                    case ')' :
                        if(stack.isEmpty() || stack.peek() != '(') asymmetry = false;
                        else stack.pop();
                        break;
                    case ']' :
                        if(stack.isEmpty() || stack.peek() != '[') asymmetry = false;
                        else stack.pop();
                        break;
                }
            }
        }
        if(i != 0){
            if(asymmetry && stack.isEmpty()) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb);
    }
}
