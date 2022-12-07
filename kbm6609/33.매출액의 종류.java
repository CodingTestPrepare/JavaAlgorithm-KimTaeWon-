package test;
/**
 * 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
 * 각 구간별로 구하라고 했습니다.
 * 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
 * 20 12 20 10 23 17 10
 * 각 연속 4일간의 구간의 매출종류는
 * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
 * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
 * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
 * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
 * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
 * 매출액의 종류를 출력하는 프로그램을 작성하세요.
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다
 */

import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n= sc.nextInt();
        k = sc.nextInt();
        int[] arr= new int[n];

        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }
//        startTime = System.currentTimeMillis();
        solution(n,k,arr);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }

    static void solution(int n, int k, int[] arr) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        StringBuilder sb =new StringBuilder();
        int count =0;
        for(int i=0; i<n;i++){
            if(count<k){
                count++;
                hs.put(arr[i],hs.getOrDefault(arr[i],0)+1);
            }else{
                sb.append(hs.size()+" ");
                hs.put(arr[i], hs.getOrDefault(arr[i], 0) + 1);
                hs.put(arr[i-k],hs.get(arr[i-k])-1);
                if (hs.get(arr[i - k]) == 0) {
                    hs.remove(arr[i - k]);
                }
            }
        }
        sb.append(hs.size() + " ");
        System.out.println(sb);
    }
}
