package test;

/**
 * N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
 * 각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
 * 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
 */

import java.util.*;

class Main {
    static int[][] arr;
    static int n;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1},{1,1},{1,-1},{-1,1},{-1,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] =sc.nextInt();
            }
        }
        solution();
    }

    static void solution() {
        int count =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    count++;
                    aging(i,j);
                }
            }
        }
        System.out.println(count);
    }
    static void aging(int x, int y) {
        int tx,ty;
        for (int i = 0; i < move.length; i++) {
            tx =x+move[i][0];
            ty =y+move[i][1];
            if (tx >=0 &&tx<n &&ty >=0 &&ty<n && arr[tx][ty] == 1){
                arr[tx][ty] = 0;
                aging(tx,ty);
            }
        }
    }
}

