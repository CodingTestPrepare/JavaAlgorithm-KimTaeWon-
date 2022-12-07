package test;

/**
 * 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
 * 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
 * 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
 * (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
 *
 */

import java.util.*;

class Main {
    static int sum;
    static int target;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        int[][] arr =new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] =sc.nextInt();
            arr[i][1] =sc.nextInt();
        }
//        startTime = System.currentTimeMillis();
        solution(n,m,arr);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);

    }

    static void solution(int n, int m, int[][] arr) {
        target = m;
        dfs(0,0,0,arr);
        System.out.println(sum);

    }
    static void dfs(int index,int ts,int ps,int[][] arr){
        if(index>= arr.length){
            sum = Math.max(sum, ps);
            return;
        }
        if (ts + arr[index][1] <= target) {
            dfs(index+1,ts+arr[index][1],ps+arr[index][0],arr);
        }
        dfs(index+1,ts,ps,arr);
    }

}
