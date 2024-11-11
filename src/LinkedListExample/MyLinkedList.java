package LinkedListExample;

class MyLinkedList {
    Node head;
    Node tail;
    boolean allowDuplication;

    public MyLinkedList() {
        this.allowDuplication = false;
    }

    public MyLinkedList(boolean allowDuplication) {
        this.allowDuplication = allowDuplication;
    }

    public void addHeadNode(Node node){ //앞에 추가
        if (head == null) {
            head = node;
            tail = node;
        }
        if (allowDuplication) {
            head.front = node;
            node.rear = head;
            head = node;
        } else if (checkDuplicate(node.value)) {
            System.out.println("중복된 값 입니다");
        } else {
            head.front = node;
            node.rear = head;
            head = node;
        }
    }

    public void addTailNode(Node node){ //뒤에 추가
        if (head == null) {
            head = node;
            tail = node;
        }
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

    public void showFromHead(){ //앞에서부터 출력
        Node current = head;
        while (true) {
            System.out.println(current.value);
            if(current.rear == null)
                break;
            current = current.rear;
        }
    }

    public void showFromTail(){ //뒤에서부터 출력
        Node current = tail;
        while (true) {
            System.out.println(current.value);
            if(current.front == null)
                break;
            current = current.front;
        }
    }

    public void sortList(boolean ascending){
        if(ascending){

        }else{

        }
    }
    private boolean checkDuplicate(int inputValue){ //중복체크메서드
        Node current = head;
        while(true){
            if(current.value == inputValue){
                return true;
            }
            if(current.rear==null){
                return false;
            }
            current = current.rear;
        }
    }
}