package test;

/**
 *
 * 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
 * 현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
 * 송아지는 움직이지 않고 제자리에 있다.
 * 현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
 * 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요
 * 첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.
**/


import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
//        startTime = System.currentTimeMillis();
        solution(n,m);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }

    static void solution(int n,int m) {
        Queue<Integer> qu = new LinkedList<>();
        boolean[] check = new boolean[10001];
        qu.add(n);
        int count = 0;
        int len;
        leaf:
        while (!qu.isEmpty()) {
            len = qu.size();
            for (int i = 0; i < len; i++) {
                Integer poll = qu.poll();
                if (poll == m) {
                    break leaf;
                }
                if (poll + 1 <= 10000)
                    {
                        if (!check[poll + 1]) {
                            qu.add(poll + 1);
                            check[poll] = true;
                        }
                    }
                if (poll - 1 >= 1) {
                    if (!check[poll - 1]) {
                        qu.add(poll - 1);
                        check[poll - 1] = true;
                    }
                }
                if (poll + 5 <= 10000) {
                    if (!check[poll + 5]) {
                        qu.add(poll + 5);
                        check[poll + 5] = true;
                    }
                }
            }
            count++;
        }
        System.out.println(count);
    }
}