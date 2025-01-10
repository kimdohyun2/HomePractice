package coding_test.dec_3rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;

public class Dohyun11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]), k = Integer.parseInt(in[1]);
        Deque<Integer> deque = new java.util.ArrayDeque<>();
        for(int i=1; i<=n; i++){
            deque.offerLast(i);
        }

        StringBuffer sb = new StringBuffer();
        sb.append("<");
        while(deque.size()>1){
            for(int i=0; i<k-1; i++){
                deque.offerLast(deque.pollFirst());
            }
            sb.append(deque.pollFirst()).append(", ");
        }
        sb.append(deque.pollFirst()).append(">");
        System.out.println(sb);
    }
}
