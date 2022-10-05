import java.io.*;
import java.util.PriorityQueue;

/**
 * 백준 문제
 * 2667(단지번호 붙이기)
 * https://www.acmicpc.net/problem/2667
 */
public class Main {
    static int[][] move = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map =new int[n][n];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }
        solution1( map, n);
    }


    static void solution1(int[][] map, int n) {
        int count = 0;
        PriorityQueue<Integer> pq =new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1){
                    count++;
                    pq.add(dfs(map,j,i));
                }
            }
        }

        System.out.println(count);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
    static int dfs(int[][] map,int x,int y){
        if(!(x>=0 && x<map[0].length && y>=0 && y< map.length) || map[y][x] == 0){
            return 0;
        }
        int nx,ny;
        int count = 1;
        map[y][x] =0;
        for (int i = 0; i < move.length; i++) {
            nx = x+move[i][0];
            ny = y+move[i][1];
            count += dfs(map,nx,ny);
        }
        return count;

    }

}

