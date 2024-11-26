package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Dohyun7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            String[] in = br.readLine().split(" ");
            if(in[1].equals("enter")){
                set.add(in[0]);
            }else{
                set.remove(in[0]);
            }
        }
        List<String> list = new java.util.ArrayList<>(set.stream().toList());
        list.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
