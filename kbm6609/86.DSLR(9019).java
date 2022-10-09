import java.io.*;
import java.util.*;

/**
 * 백준 문제
 * 9019(DSLR)
 * https://www.acmicpc.net/problem/9019
 */
class Main {
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            int start = Integer.parseInt(tmp[0]);
            int end = Integer.parseInt(tmp[1]);
            check = new boolean[10000];
            bw.write(solution(start, end) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static String solution(int start, int end) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(start, ""));
        while (!que.isEmpty()) {
            int queSize = que.size();
            for (int i = 0; i < queSize; i++) {
                Node poll = que.poll();
                if (poll.num == end) {
                    return poll.str;
                }
                int newNum = dMethod(poll.num);
                if (!check[newNum]) {
                    check[newNum] = true;
                    que.add(new Node(newNum, poll.str + "D"));
                }
                newNum = sMethod(poll.num);
                if (!check[newNum]) {
                    check[newNum] = true;
                    que.add(new Node(newNum, poll.str + "S"));
                }
                newNum = lMethod(poll.num);
                if (!check[newNum]) {
                    check[newNum] = true;
                    que.add(new Node(newNum, poll.str + "L"));
                }
                newNum = rMethod(poll.num);
                if (!check[newNum]) {
                    check[newNum] = true;
                    que.add(new Node(newNum, poll.str + "R"));
                }
            }
        }
        return "";
    }

    static int dMethod(int num) {
        return (2 * num) % 10000;
    }

    static int sMethod(int num) {
        return (num + 9999) % 10000;
    }

    static int lMethod(int num) {
        int[] d = getIntToArr(num);
        return getArrToInt(d, 1);
    }

    static int rMethod(int num) {
        int[] d = getIntToArr(num);
        return getArrToInt(d, 3);
    }

    static int getArrToInt(int[] d, int start) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = result * 10 + d[(i + start) % 4];
        }
        return result;
    }

    static int[] getIntToArr(int num) {
        int[] d = new int[4];
        int i = 3;
        while (num > 0) {
            d[i--] = num % 10;
            num /= 10;
        }
        return d;
    }

}

class Node {
    int num;
    String str;

    public Node(int num, String str) {
        this.num = num;
        this.str = str;
    }


}
