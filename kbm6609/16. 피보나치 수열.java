/**
 *  N 까지의 피보나치 수열 값들을 출력
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();

        solution(N);
    }
    static void solution(int N) {
        int[] fibo = new int[N];
        for (int i = 0; i < N; i++) {
            if(i==0 || i==1) fibo[i] = 1;
            else fibo[i] = fibo[i - 1] + fibo[i - 2];
            System.out.print(fibo[i]+" ");
        }
    }
}