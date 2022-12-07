import java.io.*;

/**
 * 백준 문제
 * 13459(구슬 탈출)
 * https://www.acmicpc.net/problem/13459
 */
class Main {
    static char[][] map;
    static int[][] move = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    static Point target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        map = new char[n][m];
        Point red = null, blue = null;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
            if (str.contains("R")) {
                red = new Point(i, str.indexOf("R"));
            }
            if (str.contains("B")) {
                blue = new Point(i, str.indexOf("B"));
            }
            if (str.contains("O")) {
                target = new Point(i, str.indexOf("O"));
            }
        }
        if (solution(red, blue, 0, -1)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static boolean solution(Point red, Point blue, int count, int preIndex) {
        if (count == 10) {
            return false;
        }
        Point newRed, newBlue;
        int r1, b1, r2;
        for (int i = 0; i < move.length; i++) {
            if (preIndex != i) {
                //빨강 -> 파랑 -> 빨강
                newRed = new Point(red.x, red.y);
                newBlue = new Point(blue.x, blue.y);
                r1 = movePoint(newRed, newBlue, i);
                b1 = movePoint(newBlue, newRed, i);
                r2 = movePoint(newRed, newBlue, i);
                if (r1 == 0 && r2 == 0 && b1 == 0) {
                    continue;
                }
                if (r2 == -1 && b1 != -1 || (r2 != -1 && b1 != -1 && solution(newRed, newBlue, count + 1, (i + 2) % 4))) {
                    return true;
                }
            }
        }
        return false;
    }

    static int movePoint(Point start, Point reverse, int moveIndex) {
        int nx, ny;
        nx = start.x;
        ny = start.y;
        int flag = 0;
        while (true) {
            if (map[nx][ny] == 'O') {
                flag = -1;
                break;
            }
            if (map[nx][ny] == '#' || (nx == reverse.x && ny == reverse.y)) {
                nx -= move[moveIndex][0];
                ny -= move[moveIndex][1];
                flag--;
                break;
            }
            nx += move[moveIndex][0];
            ny += move[moveIndex][1];
            flag++;
        }
        start.x = nx;
        start.y = ny;
        return flag;
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
