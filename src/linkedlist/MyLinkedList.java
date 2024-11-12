package linkedlist;


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