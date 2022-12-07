import java.io.*;

/**
 * 백준 문제
 * 2468(안전 영역)
 * https://www.acmicpc.net/problem/2468
 */
class Main {
    static int[][] map;
    static int[][] move = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp ;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            tmp =br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(tmp[j]);
                map[i][j] =a;
                min = Math.min(min,a);
            }
        }
        solution(min);
        bw.flush();
        bw.close();
    }


    static void solution(int h) {
        int count = 1;
        int result = 1;
        while (count != 0) {
            count = getSafeZone(h);
            result = Math.max(result,count);
            h++;

        }
        System.out.println(result);
    }

    static int getSafeZone(int h) {
        check =new boolean[map.length][map.length];
        int result=0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] > h && !check[i][j]) {
                    run(i, j, h);
                    result ++;
                }
            }
        }
        return result;
    }
    static void run(int i,int j,int h){
        if (i < 0 || i >= map.length || j < 0 || j >= map.length || map[i][j] <= h || check[i][j]) {
            return;
        }
        check[i][j] = true;
        for (int x = 0; x < move.length; x++) {
            int ni = move[x][0] + i;
            int nj = move[x][1] + j;
            run(ni,nj,h);
        }
    }
}
