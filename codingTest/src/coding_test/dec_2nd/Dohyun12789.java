package coding_test.dec_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Dohyun12789 {
    static Stack<Integer> stack = new Stack<>();
    static int n;
    static String[] in;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        in = br.readLine().split(" ");
        distribution();
    }

    static void distribution() {
        int count = 1;
        int pointerIn = 0;
        while(pointerIn < n || !stack.isEmpty()){
            int tmp1 = 0;
            int tmp2 = 0;
            if(pointerIn < n){
                tmp1 = Integer.parseInt(in[pointerIn]);
            }
            if(!stack.isEmpty()) {
                tmp2 = stack.peek();
            }
            if(tmp1 == count){
                pointerIn++;
                count++;
            } else if (tmp2 == count) {
                stack.pop();
                count++;
            } else if(pointerIn < n){
                stack.push(tmp1);
                pointerIn++;
            } else{
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}
