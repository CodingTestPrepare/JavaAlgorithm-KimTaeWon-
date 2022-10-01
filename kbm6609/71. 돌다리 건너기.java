package test;

import java.io.*;

/**
 * 개울은 N개의 돌로 다리를 만들어 놓았습니다.
 * 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.
 * 개울을 건너는 방법은 몇 가지일까요?
 */

class Main {
    static long[] fac = new long[12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution(n);
    }

    static void solution(int n) {
        int result = 0;
        int[] dy = new int[36];
        dy[1] = 1;
        dy[2] = 2;
        System.out.println(dyMethod(dy, n + 1));
    }

    static int dyMethod(int[] dy, int target) {
        if (dy[target] != 0) {
            return dy[target];
        }
        return dy[target] = dyMethod(dy, target - 1) + dyMethod(dy, target - 2);
    }
}
