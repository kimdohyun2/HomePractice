package coding_test.dec_3rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Dohyun1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String in = br.readLine();

        double[] alpha = new double[26];

        for (int i = 0; i < n; i++) {
            alpha[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            switch (c) {
                case '+':
                    stack.push(stack.pop() + stack.pop());
                    break;
                case '-':
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case '*':
                    stack.push(stack.pop() * stack.pop());
                    break;
                case '/':
                    double temp1 = stack.pop();
                    double temp2 = stack.pop();
                    stack.push(temp2 / temp1);
                    break;
                case '%':
                    double temp3 = stack.pop();
                    double temp4 = stack.pop();
                    stack.push(temp4 % temp3);
                    break;
                default:
                    stack.push(alpha[c - 'A']);
                    break;
            }
        }
        System.out.printf("%.2f",stack.pop());
    }
}
