package test;

import java.io.*;
import java.util.*;

/**
 * 백준 문제
 * 5719(거의 최단경로)
 * https://www.acmicpc.net/problem/5719
 */
class Main {
    static int start, end;
    static int n, m;
    static ArrayList<Edge>[] edge;
    static boolean[][] check;
    static int[] shortLen;
    static ArrayList<Integer>[] pre;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp;
        while (true) {
            tmp = br.readLine().split(" ");
            n = Integer.parseInt(tmp[0]);
            m = Integer.parseInt(tmp[1]);
            if (n == 0 && m == 0) {
                break;
            }
            tmp = br.readLine().split(" ");
            start = Integer.parseInt(tmp[0]);
            end = Integer.parseInt(tmp[1]);
            edge = new ArrayList[n];
            pre = new ArrayList[n];
            shortLen = new int[n];
            check = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                edge[i] = new ArrayList<>();
                pre[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                tmp = br.readLine().split(" ");
                int U = Integer.parseInt(tmp[0]);
                int V = Integer.parseInt(tmp[1]);
                int P = Integer.parseInt(tmp[2]);
                edge[U].add(new Edge(U, V, P));
            }
            findShortPath();
            deleteEdge(end);
            findShortPath();
            if (shortLen[end] == Integer.MAX_VALUE) {
                bw.write("-1\n");
            } else {
                bw.write(shortLen[end] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static void findShortPath() {
        Arrays.fill(shortLen, Integer.MAX_VALUE);
        PriorityQueue<PqNode> pq = new PriorityQueue<>();

        shortLen[start] = 0;
        pq.add(new PqNode(start, 0));
        while (!pq.isEmpty()) {
            PqNode poll = pq.poll();
            if (poll.index == end) {
                break;
            }
            if (poll.sum > shortLen[poll.index]) {
                continue;
            }
            for (int i = 0; i < edge[poll.index].size(); i++) {
                Edge eg = edge[poll.index].get(i);
                if (!check[eg.from][eg.to]) {
                    int len = eg.v;
                    if (len + poll.sum < shortLen[eg.to]) {
                        pre[eg.to].clear();
                        pre[eg.to].add(eg.from);
                        shortLen[eg.to] = len + poll.sum;
                        pq.add(new PqNode(eg.to, len + poll.sum));
                    } else if (len + poll.sum == shortLen[eg.to]) {
                        pre[eg.to].add(eg.from);
                    }
                }
            }
        }
    }

    static void deleteEdge(int target) {
        if (target == start) {
            return;
        }
        for (int i : pre[target]) {
            /**
             * 최단 거리 추출시 중복된 간선은 절대 사용하지 않아서 check 가 필요없는줄알앗는데
             * pre 는 중복될수가 있다.
             * ex
             * 4 4
             * 0 3
             * 0 1 1
             * 1 2 2
             * 2 3 2
             * 1 3 4
             *
             * 이 경우엔
             * index 0
             * index 1 -> pre = {0}
             * index 2 -> pre = {1}
             * index 3 -> pre ={1,2}
             * 이므로 check 로 걸러주지 않으면 1 -> 0 의 경우 2번 중복된다.
             *
             */
            if (!check[i][target]) {
            check[i][target] = true;
            deleteEdge(i);
            }
        }
    }
}

class PqNode implements Comparable<PqNode> {
    int index;
    int sum = 0;

    public PqNode(int index, int sum) {
        this.index = index;
        this.sum = sum;
    }

    @Override
    public int compareTo(PqNode o) {
        return this.sum - o.sum;
    }
}

class Edge {
    int from;
    int to;
    int v;

    public Edge(int from, int to, int v) {
        this.from = from;
        this.to = to;
        this.v = v;
    }
}
