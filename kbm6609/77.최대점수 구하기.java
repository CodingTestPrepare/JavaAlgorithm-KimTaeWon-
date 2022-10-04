import java.io.*;
import java.util.Arrays;

/**
 *  N개의 문제를 풀려고 합니다.
 * 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
 * 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
 * (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
 * 첫 번째 줄에 문제의 개수N(1<=N<=50)과 제한 시간 M(10<=M<=300)이 주어집니다.
 * 두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        String[] str = new String[n];
        for (int i = 0; i < str.length; i++) {
            str[i] = br.readLine();
        }
        solution1(str, n, m);
//        solution2(str, n, m);
    }


    static void solution1(String[] str, int n, int m) {
        int[][] arr = new int[n][m + 1];
        int[] t = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            String[] tmp = str[i].split(" ");
            t[i] = Integer.parseInt(tmp[1]);
            p[i] = Integer.parseInt(tmp[0]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (i == 0) {
                    if (t[i] <= j) {
                        arr[i][j] = p[i];
                    }
                } else {
                    if (t[i] <= j) {
                        arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - t[i]] + p[i]);
                    }else{
                        arr[i][j] = arr[i - 1][j];
                    }
                }
            }
        }
        System.out.println(arr[n-1][m]);
    }


}

