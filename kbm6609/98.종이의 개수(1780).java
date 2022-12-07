import java.io.*;

/**
 * 백준 문제
 * 1780(종이의 개수)
 * https://www.acmicpc.net/problem/1780
 */

class Main {
    static int[][] map;
    static int[] result = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            tmp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        solution(0, 0, n);
        for (int i : result) {
            System.out.println(i);
        }
    }

    static int solution(int x, int y, int len) {
        if (len == 1) {
            result[map[x][y] + 1]++;
            return map[x][y];
        }
        int num = len / 3;
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int t = solution(x + i * num, y + j * num, num);
                if (t != -2) {
                    arr[t + 1]++;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 9) {
                result[i] -= 8;
                return i - 1;
            }
        }
        return -2;
    }
}