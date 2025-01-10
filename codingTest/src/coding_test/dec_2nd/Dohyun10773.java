package coding_test.dec_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dohyun10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            int n = Integer.parseInt(br.readLine());
            if(n != 0){
                list.add(n);
            }else{
                list.remove(list.size()-1);
            }
        }
        int result = 0;
        for(int i : list){
            result += i;
        }
        System.out.println(result);
    }
}
