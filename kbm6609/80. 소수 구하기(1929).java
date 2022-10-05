import java.io.*;

/**
 * 백준 문제
 * 1929(소수 구하기)
 * https://www.acmicpc.net/problem/1929
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str= br.readLine().split(" ");
        int n =Integer.parseInt(str[1]);
        int m = Integer.parseInt(str[0]);
        solution1(n, m);
    }

    static void solution1(int n, int m) {
        boolean[] sosu = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if(!sosu[i]){
                if(i>=m){
                    System.out.println(i);
                }
                for (int j = 2; j * i <= n; j++) {
                    sosu[i * j] = true;
                }
            }
        }
    }

}

