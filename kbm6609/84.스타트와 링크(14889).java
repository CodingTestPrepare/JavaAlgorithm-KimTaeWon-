import java.io.*;

/**
 * 백준 문제
 * 14889(스타트와 링크)
 * https://www.acmicpc.net/problem/14889
 */
public class Main {
    static int[][] points;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        points =new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                points[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        solution1();
    }

    static void solution1() {
        int result  = joinTeam(0,0,0,0,0);
        System.out.println(result);

    }

    static int joinTeam(int bit, int count, int index, int aPoint, int bPoint) {
        if (count == n / 2) {
            for (int i = index; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if ((bit & (1 << j)) == 0) {
                        bPoint += points[i][j] + points[j][i];
                    }
                }
            }
            return Math.abs(aPoint - bPoint);
        }
        int min = Integer.MAX_VALUE;
        int nAPoint;
        for (int i = index; i < n; i++) {
            nAPoint = aPoint;
            for (int j = 0; j < i; j++) {
                if ((bit & (1 << j)) > 0) {
                    nAPoint += points[j][i] + points[i][j];
                }
            }
            min = Math.min(joinTeam(bit | (1 << i), count + 1, i + 1, nAPoint, bPoint), min);
            for (int j = 0; j < i; j++) {
                if ((bit & (1 << j)) == 0) {
                    bPoint += points[j][i] + points[i][j];
                }
            }
        }
        return min;
    }
}

