import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백준 문제
 * 12851(숨바꼭질2)
 * https://www.acmicpc.net/problem/12851
 */
class Main {
    static int[] check1 = new int[200000];
    static int[] check2 = new int[200000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        solution(n, m);
    }

    static void solution(int start, int target) {
        Queue<Integer> que = new LinkedList<>();
        Arrays.fill(check1, Integer.MAX_VALUE);
        int count1 = 0;
        int np;
        que.add(start);
        check2[start] = 1;
        //check1 == 도달 하는데 까지 걸린 시간
        //check2 == 같은 시간이 걸린 경우의수
        l1 : while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                Integer poll = que.poll();
                if (poll == target) {
                    break l1;
                }
                np = poll + 1;
                addQueue(poll,np,que,count1);
                np = poll - 1;
                addQueue(poll,np,que,count1);
                np = poll * 2;
                addQueue(poll,np,que,count1);
            }
            count1++;
        }
        System.out.println(count1);
        System.out.println(check2[target]);
    }
    static void addQueue(int poll, int np, Queue<Integer> que, int count1) {
        if (np < 0 || np >= 200000) {
            return;
        }
        if (check1[np] >= count1) {
            check2[np] += check2[poll];
            if (check1[np] != count1) {
                check1[np] = count1;
                que.add(np);
            }
        }
    }
}
