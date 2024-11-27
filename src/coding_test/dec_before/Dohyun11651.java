package coding_test.dec_before;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Dohyun11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            String[] in = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(in[0]);
            arr[i][1] = Integer.parseInt(in[1]);
        }
        br.close();
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });

        for(int[] i : arr){
            bw.write(i[0]+" "+i[1]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
