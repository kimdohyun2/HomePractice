package coding_test.dec_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dohyun28278 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            String[] in  = br.readLine().split(" ");
            switch (in[0]){
                case "1":
                    list.add(Integer.parseInt(in[1]));
                    break;
                case "2":
                    if(list.isEmpty()) {
                        sb.append("-1").append('\n');
                    }else{
                        int last = list.size() - 1;
                        sb.append(list.get(last)).append('\n');
                        list.remove(last);
                    }
                    break;
                case "3":
                    sb.append(list.size()).append('\n');
                    break;
                case "4":
                    if(list.isEmpty()) {
                        sb.append("1").append('\n');
                    }else{
                        sb.append("0").append('\n');
                    }
                    break;
                case "5":
                    if(list.isEmpty()) {
                        sb.append("-1").append('\n');
                    }else{
                        sb.append(list.get(list.size() - 1)).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
