package test;
/**
 * N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr =new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
//        long startTime,finishTime,elapsedTime;
//        startTime= System.currentTimeMillis();
        solution(N,K,arr);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }
    static void solution(int N,int K, int[] arr) {
        int result =0;
        int kSum=0;
        for (int i = 0; i < K; i++) {
            kSum += arr[i];
        }
        result = kSum;
        for (int i = K; i < N; i++) {
            kSum += arr[i] - arr[i - K];
            if(kSum > result) result = kSum;
        }
        System.out.println(result);

    }
}