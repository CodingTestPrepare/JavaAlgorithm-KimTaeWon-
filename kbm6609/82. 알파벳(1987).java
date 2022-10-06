import java.io.*;

/**
 * 백준 문제
 * 1987(알파벳)
 * https://www.acmicpc.net/problem/1987
 */
public class Main {
    static int r, c;
    static char[][] arr;
    static boolean[] check;
    static int[][] move = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        r = Integer.parseInt(str[0]);
        c = Integer.parseInt(str[1]);
        arr =new char[r][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        check =new boolean[26];
        solution1();
    }

    static void solution1() {
        int result = dfs(0,0,0);
        System.out.println(result);
    }

    static int dfs(int x, int y, int count) {
        if(!(x>=0 && x<r &&y>=0 &&y<c) || check[arr[x][y] -'A']){
            return count;
        }
        count++;
        check[arr[x][y] -'A'] =true;
        int max =0;
        for (int i = 0; i < move.length; i++) {
            max = Math.max(max, dfs(x+move[i][0] , y+move[i][1], count));
        }
        check[arr[x][y] -'A'] =false;
        return max;
    }
}

