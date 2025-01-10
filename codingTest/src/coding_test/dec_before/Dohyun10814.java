package coding_test.dec_before;

import java.io.*;
import java.util.ArrayList;

public class Dohyun10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<User> list = new ArrayList<>();
        String[] in;
        for(int i=0; i<n; i++){
            in = br.readLine().split(" ");
            list.add(new User(Integer.parseInt(in[0]),in[1]));
        }
        list.sort((o1, o2) -> o1.age - o2.age);

        for(User user : list){
            bw.write(user.age+" "+user.name+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class User{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
