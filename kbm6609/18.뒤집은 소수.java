/**
 *  첫줄에 자연수 N 이 입력된다.
 *  두번째 줄에 N 개의 자연수가 입력된다.
 *  이때 각 자연수들의 뒤집은 수가 소수 라면 그 소수를 출력하는 프로그램 작성
 *  예) 32 -> 23(소수)    출력 : 23
 *
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int[] arr =new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }
        solution(N,arr);
    }

    static void solution(int N, int[] arr) {
        for (int i : arr) {
            int reverse =reversInt(i);
            if(checkPrime(reverse)) System.out.print(reverse+" ");
        }
    }
    static boolean checkPrime(int n) {
        if(n <2) return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    static int reversInt(int num) {
        int result=0;
        while (num != 0) {
            result =result*10 + num % 10;
            num /=10;
        }
        return result;
    }
}