package coding_test.dec_before;

import java.io.*;
import java.util.HashMap;

public class Dohyun1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        HashMap<String, Integer> map = new HashMap<>();
        String[] map2 = new String[n+1];
        for(int i=1; i<=n; i++){
            String pokemon = br.readLine();
            map.put(pokemon,i);
            map2[i] = pokemon;
        }

        for (int i = 0; i < m; i++) {
            String check = br.readLine();
            if (0<check.charAt(0)-'0' && check.charAt(0)-'0'<=9){
                bw.write(map2[Integer.parseInt(check)]);
                bw.newLine();

            }else{
                bw.write(String.valueOf(map.get(check)));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
