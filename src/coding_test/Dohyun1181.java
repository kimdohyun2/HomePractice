package coding_test;

import java.io.*;
import java.util.*;

public class Dohyun1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            set.add(br.readLine());
        }
        ArrayList<String> list = new ArrayList<>(set);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    for(int i=0; i<o1.length(); i++){
                        if(o1.charAt(i)-o2.charAt(i) != 0) {
                            return o1.charAt(i) - o2.charAt(i);
                        }
                    }
                    return 0;
                }else{
                    return o1.length() - o2.length();
                }
            }
        });
        for(String s : list){
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
    }
}
