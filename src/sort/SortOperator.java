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
                    break;
                }
                case "3": {
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
            System.out.println();
        }
    }

    void selectSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int max = 0;
            for(int j=0; j< arr.length-i; j++){
                if(arr[max] < arr[j]){
                    max = j;
                }
            }
            if(i != max) {
                int temp = arr[max];
                arr[max] = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = temp;
            }
            System.out.print(i+1+"회 정렬 후 ");
            show(arr);
        }
    }

    void insertSort(int[] arr){
        for(int i=0; i<arr.length; i++){

        }
    }

    /*int[] mergeSort(int[] arr){

    }
    int[] heapSort(int[] arr){

    }
    int[] quickSort(int[] arr){

    }*/

    void show(int[] arr){
        System.out.print("배열상태 : ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
