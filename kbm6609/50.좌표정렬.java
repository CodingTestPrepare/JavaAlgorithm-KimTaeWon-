package test;

/**
 *
 * N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
 * 정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
 *
 *
 * 입력
**/


import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[][] arr =new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
//        startTime = System.currentTimeMillis();
        solution(n,arr);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }

    static void solution(int n, int[][] arr) {
        PriorityQueue<Point> pq =new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            pq.add(new Point(arr[i][0],arr[i][1]));
        }
        while (!pq.isEmpty()) {
            Point poll = pq.poll();
            sb.append(poll.x + " "+poll.y+"\n");
        }
        System.out.print(sb);
    }
}

class Point implements Comparable<Point> {
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x!=o.x) {
            return this.x - o.x;
        }else{
            return this.y - o.y;
        }
    }
}