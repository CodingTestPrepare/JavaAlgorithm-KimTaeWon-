package test;
/**
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
 * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
 * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nArr =new int[N];
        for (int i = 0; i < N; i++) {
            nArr[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] mArr =new int[M];
        for (int i = 0; i < M; i++) {
            mArr[i] =sc.nextInt();
        }
//        long startTime,finishTime,elapsedTime;
//        startTime= System.currentTimeMillis();
        solution(N,M,nArr,mArr);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }
    static void solution(int N,int M, int[] nArr,int[] mArr) {
        StringBuilder sb =new StringBuilder();
        Arrays.sort(nArr);
        Arrays.sort(mArr);
        int i=0,j=0;
        while(i<N&&j<M){
            if(nArr[i] == mArr[j]){
                sb.append(nArr[i]+" ");
                i++;
                j++;
            }else if(nArr[i] <mArr[j]){
                i++;
            }else{
                j++;
            }
        }
        System.out.println(sb);
    }
}