package coding_test.dec_before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dohyun2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int first = Integer.parseInt(br.readLine());
        int before = first;
        int current = 0;
        int gcd = 0;
        for(int i=2; i<=n; i++){
            current = Integer.parseInt(br.readLine());
            int len = current - before;
            gcd = Euclidean(len, gcd);
            before = current;
        }
        System.out.println(((current - first) / gcd) - (n-1));
    }

    static int Euclidean(int n1, int n2){
        if(n2 == 0){
            return n1;
        }
        return Euclidean(n2, n1%n2);
    }
}
