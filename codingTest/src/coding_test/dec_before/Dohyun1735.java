package coding_test.dec_before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dohyun1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in1 = br.readLine().split(" ");
        String[] in2 = br.readLine().split(" ");

        int a = Integer.parseInt(in1[0])*Integer.parseInt(in2[1]) + Integer.parseInt(in1[1])*Integer.parseInt(in2[0]);
        int b = Integer.parseInt(in1[1])*Integer.parseInt(in2[1]);

        int gcd = 0;
        while(gcd != 1){
            gcd = euclidean(a,b);
            a /= gcd;
            b /= gcd;
        }
        System.out.println(a+" "+b);
    }

    static int euclidean(int a, int b){
        while(b != 0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
