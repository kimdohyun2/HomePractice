package coding_test.dec_before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dohyun17103 {
    static boolean[] primeNum = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        eratosthenes();

        int n = Integer.parseInt(br.readLine());
        for(int i =0; i<n; i++){
            int goldbach = Integer.parseInt(br.readLine());
            int cnt = 0;

            int prime = 1;
            //소수의 크기가 입력값의 절반 이하까지 반복
            while((prime = nextPrime(prime))<=goldbach/2){
                //입력값 - prime이 소수라면 골드바흐 케이스 cnt++
                if(!primeNum[goldbach-prime]){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
    //에라토스테네스의 체
    static void eratosthenes() {
        primeNum[0] = primeNum[1] = true;
        for (int i = 2; i * i < primeNum.length; i++) {
            if (!primeNum[i]) {
                for (int j = i * i; j < primeNum.length; j += i) {
                    primeNum[j] = true;
                }
            }
        }
    }
    //다음 소수
    static int nextPrime(int prime){
        for(int j=prime+1; j<primeNum.length; j++){
            if(!primeNum[j]){
                prime = j;
                break;
            }
        }
        return prime;
    }
}
