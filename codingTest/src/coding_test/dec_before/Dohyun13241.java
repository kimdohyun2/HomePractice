package coding_test.dec_before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dohyun13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        long n1 = Long.parseLong(in[0]);
        long n2 = Long.parseLong(in[1]);

        System.out.println((n1*n2)/euclidean(n1,n2));
    }

    static long euclidean(long n1, long n2){
        while(n2 != 0){
            long r = n1%n2;
            n1 = n2;
            n2 = r;
        }
        return n1;
    }
}