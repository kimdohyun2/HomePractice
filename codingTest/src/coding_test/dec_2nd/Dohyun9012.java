package coding_test.dec_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dohyun9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k; i++) {
            String in = br.readLine();
            int n = 0;
            for (char c : in.toCharArray()) {
                if (c == '(') n++;
                else {
                    n--;
                    if(n<0){
                        break;
                    }
                }
            }
            if(n == 0) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
