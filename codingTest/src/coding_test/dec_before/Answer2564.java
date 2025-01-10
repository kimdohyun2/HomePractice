package coding_test.dec_before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Answer2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int x = Integer.parseInt(in[0]);
        int y = Integer.parseInt(in[1]);
        int n = Integer.parseInt(br.readLine());
        int[][] des= new int[n+1][2];
        for (int i = 0; i <= n; i++) {
            in = br.readLine().split(" ");
            des[i][0] = Integer.parseInt(in[0]);
            des[i][1] = Integer.parseInt(in[1]);
        }
        int[] lenArr = new int[n+1];
        for (int i = 0; i <= n; i++) {
            int len = 0;
            switch (des[i][0]){
                case 1:
                    len = des[i][1];
                    break;
                case 2:
                    len = 2*x+y-des[i][1];
                    break;
                case 3:
                    len = 2*x+2*y-des[i][1];
                    break;
                case 4:
                    len = x+des[i][1];
                    break;
            }
            lenArr[i] = len;
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            int desLen = Math.abs(lenArr[i]-lenArr[n]);
            sum += Math.min(desLen, 2*x+2*y-desLen);
        }
        System.out.println(sum);
    }
}
