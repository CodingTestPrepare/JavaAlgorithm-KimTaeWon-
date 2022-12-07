import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 백준 문제
 * 13913(숨바꼭질4)
 * https://www.acmicpc.net/problem/13913
 */
class Main {
    static int[] check1 = new int[200000];
    static int target;
    static Queue<Integer> que =new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        target = Integer.parseInt(tmp[1]);
        solution(n);
    }

    static void solution(int start) {
        Arrays.fill(check1, -1);
        int count1 = 0;
        int np;
        if(start != target){
            que.add(start);
        }
        check1[start] =start;
        //check1 == 해당 지점을 가기 위해 출발한 위치를 저장
        l1:
        while (!que.isEmpty()) {
            count1++;
            int len = que.size();
            for (int i = 0; i < len; i++) {
                Integer poll = que.poll();
                if(addQueue(poll,poll-1) || addQueue(poll, poll+1) ||addQueue(poll, poll * 2)){
                    break l1;
                }
            }
        }
        System.out.println(count1);
        int tmp = target;
        Stack<Integer> st =new Stack<>();
        while (true) {
            st.add(tmp);
            if (tmp == check1[tmp]) {
                break;
            }
            tmp = check1[tmp];
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop()+" ");
        }
    }

    static boolean addQueue( int poll, int np) {
        if (np >= 0 && np < 200000 && check1[np] == -1) {
            check1[np] = poll;
            if (np == target) {
                return true;
            }
            que.add(np);
        }
        return false;
    }
}
