package test;

/**
 * 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면,
 * 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
 * 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며,
 * 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 현수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
 * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
 * 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 *
 */

import java.util.*;

class Main {
    static int[][] arr;
    static int n,m;
    static Queue<Point> qu;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n =sc.nextInt();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] =sc.nextInt();
            }
        }
        solution();
    }

    static void solution() {
        qu = new LinkedList<>();
        int count =0;
        int result=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    qu.add(new Point(i, j));
                }
                if(arr[i][j] ==0){
                    count++;
                }
            }
        }
        while(!qu.isEmpty() &&count >0){
            int len =qu.size();
            for (int i = 0; i < len; i++) {
                Point poll = qu.poll();
                count -= aging(poll.x, poll.y);
            }
            result ++;
        }
        if(count !=0){
            result =-1;
        }
        System.out.println(result);
    }
    static int aging(int x, int y) {
        int tx,ty;
        int sum=0;
        for (int i = 0; i < 4; i++) {
            tx =x+move[i][0];
            ty =y+move[i][1];
            if (tx >=0 &&tx<n &&ty >=0 &&ty<m && arr[tx][ty] == 0){
                qu.add(new Point(tx,ty));
                arr[tx][ty] = 1;
                sum++;
            }
        }
        return sum;
    }
}
class Point {
    int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}



