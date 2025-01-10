package coding_test.dec_before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Dohyun1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] in = br.readLine().split(" ");
        HashSet<String> set = new HashSet<>(Arrays.asList(in));
        in = br.readLine().split(" ");
        for(int i=0; i<in.length; i++){
            if(!set.add(in[i])){
                set.remove(in[i]);
            }
        }
        System.out.println(set.size());
    }
}
