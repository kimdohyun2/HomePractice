package coding_test.dec_3rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;

public class Dohyun2346 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<DoubleInt> deque = new java.util.ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        String[] in = br.readLine().split(" ");
        for(int i=1; i<=n; i++){
            deque.offerLast(new DoubleInt(i, Integer.parseInt(in[i-1])));
        }

        StringBuilder sb = new StringBuilder();
        while(deque.size()>1){
            DoubleInt target = deque.pollFirst();
            int add = target.add;
            sb.append(target.num).append(" ");

            if(add<0){
                for(int i=0; i<Math.abs(add); i++){
                    deque.offerFirst(deque.pollLast());
                }
            }else{
                for(int i=0; i<Math.abs(add)-1; i++){
                    deque.offerLast(deque.pollFirst());
                }
            }
        }
        sb.append(deque.pollLast().num);
        System.out.println(sb);
    }

    static class DoubleInt{
        int num;
        int add;

        public DoubleInt(int num, int add) {
            this.num = num;
            this.add = add;
        }
    }
}
