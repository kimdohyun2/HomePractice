package coding_test.dec_3rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Deque;

public class Dohyun28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new java.util.ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            String[] in = br.readLine().split(" ");
            switch (in[0]) {
                case "1":
                    deque.offerFirst(Integer.parseInt(in[1]));
                    break;
                case "2":
                    deque.offerLast(Integer.parseInt(in[1]));
                    break;
                case "3":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.pollFirst()).append('\n');
                    }
                    break;
                case "4":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.pollLast()).append('\n');
                    }
                    break;
                case "5":
                    sb.append(deque.size()).append('\n');
                    break;
                case "6":
                    if (deque.isEmpty()) {
                        sb.append("1\n");
                    }else{
                        sb.append("0\n");
                    }
                    break;
                case "7":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    }else{
                        sb.append(deque.peekFirst()).append('\n');
                    }
                    break;
                case "8":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    }else{
                        sb.append(deque.peekLast()).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
