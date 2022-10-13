import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백준 문제
 * 6593(상범 빌딩)
 * https://www.acmicpc.net/problem/6593
 */
class Main {
    static char[][][] map;
    static int[][] move = {
            {0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {0, -1, 0}, {1, 0, 0,}, {-1, 0, 0}
    };
    static int l, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String[] tmp = br.readLine().split(" ");
            l = Integer.parseInt(tmp[0]);
            r = Integer.parseInt(tmp[1]);
            c = Integer.parseInt(tmp[2]);
            if (l == 0 && r == 0 && c == 0) {
                break;
            }
            map = new char[l][r][];
            Point start = null, end = null;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String t = br.readLine();
                    map[i][j] = t.toCharArray();
                    if (t.contains("S")) {
                        start = new Point(i, j, t.indexOf("S"));
                    } else if (t.contains("E")) {
                        end = new Point(i, j, t.indexOf("E"));
                    }
                }
                br.readLine();
            }
            solution(start, end);
        }
    }

    static void solution(Point start , Point end) {

        Queue<Point> que = new LinkedList<>();
        int count = 0;
        map[start.z][start.x][start.y] = '#';
        que.add(new Point(start.z, start.x, start.y));
        while (!que.isEmpty()) {
            int queSize = que.size();
            for (int i = 0; i < queSize; i++) {
                Point poll = que.poll();
                if(poll.equals(end)){
                    System.out.println("Escaped in "+count+" minute(s).");
                    return;
                }
                for (int j = 0; j < move.length; j++) {
                    int nz = poll.z + move[j][0];
                    int nx = poll.x + move[j][1];
                    int ny = poll.y + move[j][2];
                    if (nz < 0 || nz >= l || nx < 0 || nx >= r || ny < 0 || ny >= c || map[nz][nx][ny] == '#' ) {
                        continue;
                    }
                    map[nz][nx][ny] = '#';
                    que.add(new Point(nz, nx, ny));
                }
            }
            count++;
        }
        System.out.println("Trapped!");
    }

}

class Point {
    int x, y, z;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y && z == point.z;
    }

    @Override
    public String
    toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public Point(int z, int x, int y) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}