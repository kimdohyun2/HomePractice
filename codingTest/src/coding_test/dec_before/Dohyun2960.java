package coding_test.dec_before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Dohyun2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        boolean[] eratos = new boolean[n+1];
        Arrays.fill(eratos, true);

        int count = 0, deleteK = 0;
        loop :
        for (int i = 2; i <= n; i++) {
            if(eratos[i]) {
                for (int j = i; j <= n; j = j + i) {
                    if (eratos[j]) {
                        eratos[j] = false;
                        count++;
                        if (count == k) {
                            deleteK = j;
                            break loop;
                        }
                    }
                }
            }
        }
        System.out.println(deleteK);
    }
}
