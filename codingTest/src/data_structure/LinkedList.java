package data_structure;

import java.io.*;

public class LinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("연결리스트의 중복을 허용하시겠습니다?(Y/N) : ");
        bw.flush();

        DoublyLinkedList ll;
        if(br.readLine().equals("Y")) {
            ll = new DoublyLinkedList(true);
        }else {
            ll = new DoublyLinkedList();
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

    static class Node{
        int value;
        Node front;
        Node rear;

        public Node(int v) {
            this.value = v;
            this.front = null;
            this.rear = null;
        }
    }

    static class DoublyLinkedList {
        Node head;
        Node tail;
        boolean allowDuplication;

        public DoublyLinkedList() {
            this.allowDuplication = false;
        }

        public DoublyLinkedList(boolean allowDuplication) {
            this.allowDuplication = allowDuplication;
        }

        public void addHeadNode(Node node){ //앞에 추가
            if (head == null) { //첫입력
                head = node;
                tail = node;
            }else {
                if (allowDuplication) { //중복허용이라면
                    head.front = node;
                    node.rear = head;
                    head = node;
                } else if (checkDuplicate(node.value)) { //중복허용이 아닌데 중복된값이 들어왔다면
                    System.out.println("중복된 값 입니다");
                } else {
                    head.front = node;
                    node.rear = head;
                    head = node;
                }
            }
        }

        public void addTailNode(Node node){ //뒤에 추가
            if (head == null) {
                head = node;
                tail = node;
            }else {
                if (allowDuplication) {
                    tail.rear = node;
                    node.front = tail;
                    tail = node;
                } else if (checkDuplicate(node.value)) {
                    System.out.println("중복된 값 입니다");
                } else {
                    tail.rear = node;
                    node.front = tail;
                    tail = node;
                }
            }
        }

        public void sortList(){
            Node end = tail;
            while(this.head != end){
                Node current = this.head;
                while(current != end){
                    if(current.value>current.rear.value){
                        int temp = current.value;
                        current.value = current.rear.value;
                        current.rear.value = temp;
                    }
                    current = current.rear;
                }
                end = end.front;
            }
        }

        public void showFromHead(){ //앞에서부터 출력
            Node current = head;
            while (current != null) {
                System.out.print(current.value+" ");
                current = current.rear;
            }
        }

        public void showFromTail(){ //뒤에서부터 출력
            Node current = tail;
            while (current != null) {
                System.out.println(current.value+" ");
                current = current.front;
            }
        }

        private boolean checkDuplicate(int inputValue){ //중복체크메서드
            Node current = head;
            while(current != null){
                if(current.value == inputValue){
                    return true;
                }
                current = current.rear;
            }
            return false;
        }
    }
}


