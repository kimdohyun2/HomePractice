package coding_test.dec_before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Dohyun11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        String in = br.readLine();
        for(int i=0; i<in.length(); i++){
            for(int j=i+1; j<=in.length(); j++){
                set.add(in.substring(i,j));
            }
        }
        System.out.println(set.size());
    }
}