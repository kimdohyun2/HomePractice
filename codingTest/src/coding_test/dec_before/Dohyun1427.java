package coding_test.dec_before;

import java.io.*;
import java.util.*;

public class Dohyun1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Coordinate> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            list.add(new Coordinate(Integer.parseInt(in[0]), Integer.parseInt(in[1])));
        }
        list.sort(new Comparator<Coordinate>(){
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                if(o1.x == o2.x){
                    return o1.y - o2.y;
                }else{
                    return o1.x - o2.x;
                }
            }
        });

        for(Coordinate c : list){
            bw.write(c.x+" "+c.y+"\n");
        }
        bw.flush();
        bw.close();
    }

    static class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}