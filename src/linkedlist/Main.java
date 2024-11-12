package linkedlist;

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
        }else {
            ll = new MyLinkedList();
        }
        while(true){
            System.out.print("\n정수를 입력하시오(탈출시 X입력) : ");
            String input = br.readLine();
            if(input.equals("X")){
                break;
            }else{
                ll.addTailNode(new Node(Integer.parseInt(input)));
                ll.showFromHead();
            }
        }

        System.out.print("정렬 전 : ");
        ll.showFromHead();
        ll.sortList();
        System.out.print("\n\n정렬 후 : ");
        ll.showFromHead();
    }
}


