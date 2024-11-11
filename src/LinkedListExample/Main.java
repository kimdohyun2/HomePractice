package LinkedListExample;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("연결리스트의 중복을 허용하시겠습니다?(Y/N) : ");
        bw.flush();

        MyLinkedList ll;
        if(br.readLine().equals("Y")) {
            ll = new MyLinkedList(true);
        }else{
            ll = new MyLinkedList();
        }
        for (int i = 1; i <= 10; i++) {
            ll.addHeadNode(new Node(i));
        }
        ll.showFromHead();
        for (int i = 1; i <= 10; i++) {
            ll.addHeadNode(new Node(i));
        }
        ll.showFromHead();
    }
}


