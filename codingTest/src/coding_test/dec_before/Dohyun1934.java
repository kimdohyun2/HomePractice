package coding_test.dec_before;

import java.io.*;

public class Dohyun1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String[] in = br.readLine().split(" ");
            int A = Integer.parseInt(in[0]);
            int B = Integer.parseInt(in[1]);

            bw.write(A*B/Euclidean(A,B)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int Euclidean(int A, int B){
        while(B != 0){
            int r = A%B;
            A = B;
            B = r;
        }
        return A;
    }
}
