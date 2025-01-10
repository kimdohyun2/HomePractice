package sort;

import java.util.Random;
import java.util.Scanner;

public class SortMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        SortOperator so = new SortOperator();

        loop :
        while(true) {
            int[] arr = new int[15];
            for(int i=0; i<arr.length; i++){
                arr[i] = ran.nextInt(-100, 100);
            }
            System.out.print("1.선택 2.삽입 3.병합 4.힙 5.퀵\n입력 : ");
            String in = sc.nextLine();
            System.out.print("초기 ");
            so.show(arr);
            switch (in) {
                case "1": {
                    so.selectSort(arr);
                    break;
                }
                case "2": {
                    so.insertSort(arr);
                    break;
                }
                case "3": {
                    arr = so.mergeSort(arr);
                    break;
                }
                case "4": {
                    break;
                }
                case "5": {
                    break;
                }
                default:
                    break loop;
            }
            so.show(arr);
            System.out.println();
        }
    }
}
