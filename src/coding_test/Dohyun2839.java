package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dohyun2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int five = n/5, three = 0;
        while(five>=0){
            int remainder = n - (five*5);
            if(remainder%3 == 0){
                three = remainder/3;
                break;
            }else{
                five--;
            }
        }
        if(five<0){
            System.out.println(-1);
        }else{
            System.out.println(five+three);
        }
    }
}
