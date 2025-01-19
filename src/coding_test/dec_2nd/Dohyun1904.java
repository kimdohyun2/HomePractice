package coding_test.dec_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dohyun1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2];
        arr[0] = 1;arr[1] = 2;
        if(n <= 2){
            System.out.println(arr[n-1]);
        }else{
            for(int i=0; i<n-2; i++){
                int temp =  (arr[0]+arr[1])%15746;
                arr[0] = arr[1];
                arr[1] = temp;
            }
            System.out.println(arr[1]);
        }
    }
}
