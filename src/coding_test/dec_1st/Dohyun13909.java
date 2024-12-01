package coding_test.dec_1st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Dohyun13909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr,true);

        for(int i=2; i<=n; i++){
            for(int j=i; j<=n; j+=i){
                arr[j] = !arr[j];
            }
        }
        int cnt =0;
        for(int i=1; i<=n; i++){
            if(arr[i]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
