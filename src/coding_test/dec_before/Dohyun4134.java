package coding_test.dec_before;

import java.io.*;

public class Dohyun4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (long i = 0; i < n; i++) {
            long in = Long.parseLong(br.readLine());
            bw.write(firstBigPrimeNum(in) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static long firstBigPrimeNum(long n) {
        if (n <= 2) {
            return 2;
        } else if (n == 3){
            return 3;
        }else{
            long prime = n-1;
            loop:
            while (true) {
                prime++;
                if (prime % 2 == 0 || prime % 3 == 0) {
                    continue;
                }
                for (long i = 5; i * i <= prime; i += 6) {
                    if (prime % (i) == 0 || prime % (i+2) == 0) {
                        continue loop;
                    }
                }
                return prime;
            }
        }
    }
}