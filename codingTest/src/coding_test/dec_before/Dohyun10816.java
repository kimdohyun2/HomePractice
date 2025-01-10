package coding_test.dec_before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Dohyun10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        HashSet<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<n+m; i++){
            String insert = br.readLine();
            if(!set.add(insert)){
                list.add(insert);
            }
        }
        list.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for(String s : list){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
