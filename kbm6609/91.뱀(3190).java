import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백준 문제
 * 3190(뱀)
 * https://www.acmicpc.net/problem/3190
 */
class Main {
    static boolean[][] map;
    static int[][] move = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };// D 우측 90 -> 인덱스 증가   L 좌측 90 -> 인덱스 감소 (원형으로 유지)

    static boolean[][] check;
    static Queue<Order> orders = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp;
        int n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];
        check = new boolean[n][n];
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            tmp = br.readLine().split(" ");
            map[Integer.parseInt(tmp[0]) - 1][Integer.parseInt(tmp[1]) - 1] = true;
        }
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            tmp = br.readLine().split(" ");
            int time = Integer.parseInt(tmp[0]);
            char ch = tmp[1].charAt(0);
            orders.add(new Order(time, ch));
        }
        solution();
        bw.flush();
        bw.close();
    }


    static void solution() {
        int count = 1;
        Queue<SnackTail> snackTails = new LinkedList<>();
        snackTails.add(new SnackTail(0, 0));
        int x = 0, y = 1;
        int f = 0;
        check[0][0] = true;
        /**
         * 값들은 현재 위치를 가르키고
         * 아래서 처리 할거는 그 다음위치 갈수있는지 보고 있으면 값 변경
         *  없으면 종료
         */
        while (true) {
            if (x >= 0 && x < check.length && y >= 0 && y < check.length && !check[x][y]) {
//                System.out.println("X : " + x + "  y : " + y + " check[x][y] : "+check[x][y]);
                check[x][y] = true;
                snackTails.add(new SnackTail(x, y));
                if (!map[x][y]) {
                    SnackTail poll = snackTails.poll();
                    check[poll.x][poll.y] = false;
                } else {
                    map[x][y] = false;
                }
                if (!orders.isEmpty() && count == orders.peek().time) {
                    Order poll = orders.poll();
                    if (poll.ch == 'D') {
                        f = (f + 1) % 4;
                    } else {
                        f = (f + 3) % 4;
                    }
                }
                x += move[f][0];
                y += move[f][1];
                count++;

            } else {
                break;
            }
        }
        System.out.println(count);
    }
}

class SnackTail {
    int x, y;

    public SnackTail(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Order {
    int time;
    char ch;

    public Order(int time, char ch) {
        this.time = time;
        this.ch = ch;
    }
}
