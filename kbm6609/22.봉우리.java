package test;
/**
 * 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
 * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
 * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 *
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int[][] arr =new int[N][N];
        for (int i = 0; i < N; i++) {
            for(int j=0;j<N;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        long startTime,finishTime,elapsedTime;
        startTime= System.currentTimeMillis();
        solution(N,arr);
        finishTime = System.currentTimeMillis();
        elapsedTime = finishTime - startTime;
        System.out.println("실행 시간(ms) : " + elapsedTime);
    }
    static void solution(int N, int[][] arr) {
        int result = 0;
        int x, y;
        int[][] move = {{0, 1}, {1, 0}};
        boolean[][] map= new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 2; k++) {
                    x = i + move[k][0];
                    y = j + move[k][1];
                    if(x>=N || y >= N) continue;
                    if (arr[i][j] < arr[x][y]) {
                        map[i][j] = true;
                    }else if(arr[i][j] == arr[x][y]){
                        map[x][y] = true;
                        map[i][j] = true;
                    }else{
                        map[x][y] = true;
                    }
                }
                if (!map[i][j]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}