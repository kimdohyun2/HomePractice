package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dohyun10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int x = Integer.parseInt(in[0]);
        int y = Integer.parseInt(in[1]);
        in = br.readLine().split(" ");
        int currentX = Integer.parseInt(in[0]);
        int currentY = Integer.parseInt(in[1]);
        int t = Integer.parseInt(br.readLine());

        boolean plusX = true;
        boolean plusY = true;

        while(t>0){
            int move;
            if(plusX && plusY){
                int xx = x - currentX;
                int yy = y - currentY;
                move = Math.min(xx, yy);
                if(move < t) {
                    currentX = currentX + move;
                    currentY = currentY + move;
                }else{
                    currentX = currentX + t;
                    currentY = currentY + t;
                }
            } else if(!plusX && plusY){
                int xx = currentX;
                int yy = y - currentY;
                move = Math.min(xx, yy);
                if(move < t) {
                    currentX = currentX - move;
                    currentY = currentY + move;
                }else{
                    currentX = currentX - t;
                    currentY = currentY + t;
                }
            } else if(!plusX && !plusY){
                int xx = currentX;
                int yy = currentY;
                move = Math.min(xx, yy);
                if(move < t) {
                    currentX = currentX - move;
                    currentY = currentY - move;
                }else{
                    currentX = currentX - t;
                    currentY = currentY - t;
                }
            } else{
                int xx = x - currentX;
                int yy = currentY;
                move = Math.min(xx, yy);
                if(move < t) {
                    currentX = currentX + move;
                    currentY = currentY - move;
                }else{
                    currentX = currentX + t;
                    currentY = currentY - t;
                }
            }
            if(currentX == x || currentX == 0){
                plusX = !plusX;
            }
            if(currentY == y || currentY == 0){
                plusY = !plusY;
            }
            t = t - move;
        }
        System.out.println(currentX+" "+currentY);
    }
}
