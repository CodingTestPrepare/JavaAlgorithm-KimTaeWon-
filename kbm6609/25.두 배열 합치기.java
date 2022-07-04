package test;
/**
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 * 원소는 int형 변수의 크기를 넘지 않습니다
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
        int i=0,j=0;
        while(i<N&&j<M){
            if(nArr[i] < mArr[j]){
                sb.append(nArr[i++]+" ");
            }else{
                sb.append(mArr[j++]+" ");
            }
        }
        while(i<N){
            sb.append(nArr[i++]+" ");
        }
        while(j<M){
            sb.append(mArr[j++]+" ");
        }

        System.out.println(sb);

    }
}