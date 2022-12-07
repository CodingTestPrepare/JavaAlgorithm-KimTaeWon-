import java.io.*;
import java.util.*;

/**
 * 백준 문제
 * 5014(스타트링크)
 * https://www.acmicpc.net/problem/5014
 */
class Main {
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp = br.readLine().split(" ");
        int[] input = new int[5];
        for (int i = 0; i < 5; i++) {
            input[i] = Integer.parseInt(tmp[i]);
        }
        System.out.println(solution(input));
        bw.flush();
        bw.close();
    }


    static String solution(int[] input) {
        int[] arr = new int[2];
        arr[0] = input[3];
        arr[1] = -1 * input[4];
        int start = input[1];
        int target = input[2];
        int len = input[0];
        int count = 0;
        check = new boolean[len + 1];
        Queue<Integer> que = new LinkedList<>();
        check[start] = true;
        que.add(start);
        while (!que.isEmpty()) {
            int queSize = que.size();
            for (int i = 0; i < queSize; i++) {
                Integer poll = que.poll();
                if (poll == target) return count + "";
                for (int j : arr) {
                    int newNum = poll + j;
                    if (newNum >= 1 && newNum <= len && !check[newNum]) {
                        check[newNum] = true;
                        que.add(newNum);
                    }
                }
            }
            count++;
        }
        return "use the stairs";
    }
}
