package coding_test.dec_before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dohyun1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1, value=666, i =666;
        while (count<n){
            i++;
            String strI = i+"";

            if(strI.contains("666")) {
                value = i;
                count++;
            }
        }
        System.out.println(value);
    }
}
