import java.io.*;
import java.util.PriorityQueue;

/**
 * 백준 문제
 * 2583(영역구하기)
 * https://www.acmicpc.net/problem/2583
 */
public class Main {
    static int[][] move = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int m = Integer.parseInt(tmp[0]);
        int n = Integer.parseInt(tmp[1]);
        int k = Integer.parseInt(tmp[2]);
        String[] str = new String[k];
        for (int i = 0; i < str.length; i++) {
            str[i] = br.readLine();
        }
        solution1(str, n, m);
    }


    static void solution1(String[] str, int n, int m) {
        boolean[][] map = new boolean[m][n];
        for (int i = 0; i < str.length; i++) {
            String[] tmp =str[i].split(" ");
            int x1 = Integer.parseInt(tmp[0]);
            int y1 = Integer.parseInt(tmp[1]);
            int x2 = Integer.parseInt(tmp[2]);
            int y2 = Integer.parseInt(tmp[3]);
            for (int j = x1; j < x2; j++) {
                for (int t = y1; t < y2; t++) {
                    map[t][j] = true;
                }
            }
        }
        int count = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (!map[i][j]) {
                    count++;
                    pq.add(dfs(map,j,i));
                }
            }
        }
        System.out.println(count);
        while (!pq.isEmpty()) {
            System.out.print(pq.poll()+" ");
        }
    }
    static int dfs(boolean[][] map,int x,int y){
        if(!(x>=0 && x<map[0].length && y>=0 && y< map.length) || map[y][x]){
            return 0;
        }
        int nx,ny;
        int count = 1;
        map[y][x] =true;
        for (int i = 0; i < move.length; i++) {
            nx = x+move[i][0];
            ny = y+move[i][1];
            count += dfs(map,nx,ny);
        }
        return count;

    }

}

