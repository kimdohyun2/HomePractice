package sort;

import java.util.Arrays;
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
                    so.insertSort(arr);
                    break;
                }
                case "3": {
                    arr = so.mergeSort(arr);
                    so.show(arr);
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
        int count = 0;
        for(int i=1; i<arr.length; i++){
            int target = i;
            int temp = arr[i];
            for(int j=i-1; j>=0; j--) {
                if(arr[j]>temp){
                    arr[j+1] = arr[j];
                    target = j;
                }else {
                    break;
                }
            }

            if(target != i) {
                count++;
                arr[target] = temp;
                System.out.print(count+"회 정렬 후 ");
                show(arr);
            }
        }
    }

    int[] mergeSort(int[] arr){
        //배열이 비었거나 1개만 들어있다면 그대로 반환
        if(arr.length<=1){
            return arr;
        }
        //배열을 반으로 나눔
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr, 0,mid);
        int[] right = Arrays.copyOfRange(arr, mid,arr.length);
        //반으로 나눈 양쪽 재귀
        left = mergeSort(left);
        right = mergeSort(right);
        //정렬된 배열 병합 후 반환
        return merge(left,right);
    }

    int[] merge(int[] left, int[] right){
        //배열 포인터
        int leftP = 0, rightP = 0, mergeP = 0;
        int[] mergeArr = new int[left.length+right.length];
        //양쪽 배열을 앞쪽부터 비교해서 더 작은 수부터 병합
        while(leftP < left.length && rightP < right.length){
            if(left[leftP] < right[rightP]){
                mergeArr[mergeP] = left[leftP];
                leftP++;
            }else{
                mergeArr[mergeP] = right[rightP];
                rightP++;
            }
            mergeP++;
        }
        //남은 left배열 병합
        while(leftP<left.length){
            mergeArr[mergeP] = left[leftP];
            leftP++;
            mergeP++;
        }
        //남은 right배열 병합
        while(rightP<right.length){
            mergeArr[mergeP] = right[rightP];
            rightP++;
            mergeP++;
        }
        return mergeArr;
    }

    /*int[] heapSort(int[] arr){

    }
    int[] quickSort(int[] arr){

    }*/

    //현재 배열 상태를 보여주는 메서드
    void show(int[] arr){
        System.out.print("배열상태 : ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
