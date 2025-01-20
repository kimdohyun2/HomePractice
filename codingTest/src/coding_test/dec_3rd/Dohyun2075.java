package coding_test.dec_3rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Dohyun2075 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");;

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(in[i]);
        }
        for(int i=1; i<n; i++){
            arr = sort(arr, br.readLine().split(" "));
        }
        System.out.println(arr[0]);
    }

    static int[] sort(int[] arr, String[] in){
        int[] temp = new int[n*2];
        for(int i=0; i<n; i++){
            temp[i] = arr[i];
        }
        for(int i=n; i<n*2; i++){
            temp[i] = Integer.parseInt(in[i-n]);
        }
        Arrays.sort(temp);
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = temp[i+n];
        }
        return result;
    }
}
