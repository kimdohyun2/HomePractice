package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackExample {
    public static void main(String[] args){
        Integer[] stack = new Integer[5];
        int top = 0; //삽입할 위치
        loop :
        while (true) {
            try {
                System.out.print("삽입 '정수', 삭제 '-', 종료 '문자'\n입력 : ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String input = br.readLine();
                if(input.equals("-")){
                    if(top == 0){
                        System.out.println("스택이 비었습니다");
                    }else{
                        stack[top-1] = null;
                        top--;
                    }
                }else{
                    if(top < 5) {
                        stack[top] = Integer.parseInt(input);
                        top++;
                    }else{
                        System.out.println("스택이 꽉 찼습니다.");
                    }
                }
                System.out.print("현재 스택 : ");
                for(Integer i : stack){
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
