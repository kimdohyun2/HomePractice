package coding_test.dec_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Dohyun2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            deque.addLast(i);
        }
        while(deque.size()>1){
            deque.pollFirst();
            deque.addLast(deque.pollFirst());
        }
        System.out.println(deque.peek());
    }
}
