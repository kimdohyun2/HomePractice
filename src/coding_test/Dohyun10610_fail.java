package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Dohyun10610_fail {
    static ArrayList<Long> numberCase = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] numbers = br.readLine().toCharArray();
        mulOf30(numbers,null);

        numberCase.sort(Collections.reverseOrder());
        long output = -1;
        for(Long i : numberCase){
            if(i%30 == 0){
                output = i;
                break;
            }
        }
        System.out.println(output);
    }

    static void mulOf30(char[] numbers, char[] resultNumber){
        StringBuilder sb = new StringBuilder();
        if(numbers.length == 1){;
            sb.append(new String(resultNumber));
            sb.append(new String(numbers));
            numberCase.add(Long.parseLong(sb.toString()));
            return;
        }
        for(int i=0; i<numbers.length; i++){
            if(resultNumber == null){
                char[] numbers2 = new char[numbers.length-1];
                int count = 0;
                for (int j = 0; j < numbers.length; j++) {
                    if(i != j){
                        numbers2[count] = numbers[j];
                        count++;
                    }
                }
                char[] resultNumber2 = new char[1];
                resultNumber2[0] = numbers[i];
                mulOf30(numbers2,resultNumber2);
            }else {
                char[] numbers2 = new char[numbers.length-1];
                int count = 0;
                for (int j = 0; j < numbers.length; j++) {
                    if(i != j){
                        numbers2[count] = numbers[j];
                        count++;
                    }
                }
                char[] resultNumber2 = new char[resultNumber.length+1];
                for (int j = 0; j < resultNumber.length; j++) {
                    resultNumber2[j] = resultNumber[j];
                }
                resultNumber2[resultNumber.length] = numbers[i];
                mulOf30(numbers2,resultNumber2);
            }
        }

    }
}
