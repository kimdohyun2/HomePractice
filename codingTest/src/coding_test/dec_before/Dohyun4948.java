package coding_test.dec_before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dohyun4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n;
        while((n = Integer.parseInt(br.readLine())) != 0){
            boolean[] arr = new boolean[2*n+1];
            arr[0] = arr[1] = true;
            for(int i=2; i*i<=n*2; i++){
                for(int j=i*i; j<=n*2; j += i){
                    if(!arr[i]){
                        arr[j] = true;
                    }
                }
            }
            int cnt = 0;
            for(int i=n+1; i<=n*2; i++){
                if(!arr[i]){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
