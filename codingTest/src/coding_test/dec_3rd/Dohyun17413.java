package coding_test.dec_3rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dohyun17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        StringBuilder sb = new StringBuilder();

        boolean open = false;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if (open) {
                if (c == '>') {
                    sb.append(temp);
                    sb.append(c);
                    temp = new StringBuilder();
                    open = false;
                } else {
                    temp.append(c);
                }
            } else {
                if (i == in.length() - 1) {
                    temp.append(c);
                    sb.append(temp.reverse());
                } else {
                    if (c == '<') {
                        sb.append(temp.reverse());
                        sb.append(c);
                        temp = new StringBuilder();
                        open = true;
                    } else if (c == ' ') {
                        sb.append(temp.reverse());
                        sb.append(c);
                        temp = new StringBuilder();
                    } else {
                        temp.append(c);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
