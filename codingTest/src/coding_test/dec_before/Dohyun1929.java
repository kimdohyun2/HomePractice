package coding_test.dec_before;

import java.io.*;

public class Dohyun1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int start = Integer.parseInt(in[0]);
        int end = Integer.parseInt(in[1]);

        boolean[] arr = new boolean[end+1];
        arr[0] = arr[1] = true;

        for(int i=2; i*i<=end; i++){
            if(!arr[i]){
                for(int j=i*i; j<=end; j+=i){
                    arr[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=start; i<=end; i++){
            if(!arr[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
