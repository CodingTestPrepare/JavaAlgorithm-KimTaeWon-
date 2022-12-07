package test;

/**
 * 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
 *
 */

import java.util.*;

class Main {
    static int k=Integer.MAX_VALUE;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                arr[i][j] =sc.nextInt();
            }
        }
        solution(arr);
    }

    static void solution(int[][] arr) {
        arr[0][0]=2;
        dfs(arr, 0, 0,0);
        System.out.println(k==Integer.MAX_VALUE ? -1: k);
    }

    static void dfs(int[][] arr, int x, int y,int c) {
        if(c>=k){
            return ;
        }
        if (x == 6 && y == 6 ) {
            k = c;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int tx =x + move[i][0];
            int ty =y + move[i][1];
            if (tx >= 0 && tx < 7 && ty >= 0 && ty < 7 && arr[tx][ty] ==0) {
                arr[tx][ty] =2;
                dfs(arr, tx, ty,c+1);
                arr[tx][ty]=0;
            }
        }
    }
}



