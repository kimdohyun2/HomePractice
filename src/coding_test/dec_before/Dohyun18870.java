package coding_test.dec_before;

import java.io.*;
import java.util.*;

public class Dohyun18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        String[] in = br.readLine().split(" ");
        Set<String> set = new HashSet<>(Arrays.asList(in));
        ArrayList<String> arr = new ArrayList<>(set);

        arr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });

        int[] out = new int[n];
        for(int i=0; i<n; i++){
            out[i] = Collections.binarySearch(arr, in[i], new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.parseInt(o1) - Integer.parseInt(o2);
                }
            });
        }
        for(int i=0; i<n; i++){
            bw.write(out[i]+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
