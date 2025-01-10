package coding_test.dec_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Dohyun18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            String[] in = br.readLine().split(" ");
            switch (in[0]){
                case "push":
                    deque.push(Integer.parseInt(in[1]));
                    break;
                case "pop":
                    if(deque.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(deque.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if(deque.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case "front":
                    if(deque.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(deque.getLast()).append("\n");
                    break;
                case "back":
                    if(deque.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(deque.getFirst()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
