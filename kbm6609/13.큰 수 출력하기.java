package test;
/**
 * N 개의 정수를 입력 받아, 자신의 바로 앞 수보다 큰 수만 출력하시오.
 * 첫번째 수는 무조건 출력
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int[] arr =new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }
        solution(arr, N);
    }
    static void solution(int[] arr, int N) {
        System.out.print(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                System.out.print(" "+arr[i]);
            }
        }
    }
}