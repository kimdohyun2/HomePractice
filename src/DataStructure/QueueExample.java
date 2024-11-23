package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QueueExample {
    public static void main(String[] args){
        Integer[] queue = new Integer[6];//인덱스 0번은 temp로 사용;
        int front = 1;
        loop :
        while (true) {
            try {
                System.out.print("삽입 '정수', 삭제 '-', 종료 '문자'\n입력 : ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String input = br.readLine();
                if(input.equals("-")){
                    if(front == 1){
                        System.out.println("큐가 비었습니다.");
                    }else if(front == 2){
                        queue[1] = null;
                        front--;
                    }else{
                        for(int i=1; i<=front-1; i++){
                            queue[i-1] = queue[i];
                        }
                        queue[front-1] = null;
                        queue[0] = null;
                        front--;
                    }
                }else{
                    if(front < 6){
                        queue[front] = Integer.parseInt(input);
                        front++;
                    }else{
                        System.out.println("큐가 꽉 찼습니다.");
                    }
                }
                System.out.print("현재 큐 : ");
                for(Integer i : queue){
                    if(i != null)
                        System.out.print(i+" ");
                }
                System.out.println("\n");
            } catch (NumberFormatException e) {
                System.out.println("종료합니다...");
                break loop;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
