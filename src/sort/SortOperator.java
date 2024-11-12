package sort;

import java.util.Random;
import java.util.Scanner;

public class SortOperator {
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
            so.show(arr);
            System.out.print("1.선택 2.삽입 3.병합 4.힙 5.퀵\n입력 : ");
            switch (sc.nextLine()) {
                case "1": {
                    continue;
                }
                case "2": {
                    continue;
                }
                case "3": {
                    continue;
                }
                case "4": {
                    continue;
                }
                case "5": {
                    continue;
                }
                default:
                    break loop;
            }
        }
    }

    void selectSort(int[] arr){

    }
    void insertSort(int[] arr){

    }
    void mergeSort(int[] arr){

    }
    void heapSort(int[] arr){

    }
    void quickSort(int[] arr){

    }

    void show(int[] arr){
        System.out.print("배열상태 : ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
    }
}
