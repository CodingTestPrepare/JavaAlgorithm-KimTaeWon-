import java.io.*;
import java.util.ArrayList;

/**
 * 백준 문제
 * 15684(사다리 조작)
 * https://www.acmicpc.net/problem/15684
 */
public class Main {
    static boolean[][] sadary;
    static ArrayList<Point> arr = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]); // 세로선
        int m = Integer.parseInt(tmp[1]); // 가로선
        int h = Integer.parseInt(tmp[2]); // 높이
        sadary = new boolean[h][n - 1];
        for (int i = 0; i < m; i++) {
            tmp = br.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]) - 1;
            int y = Integer.parseInt(tmp[1]) - 1;
            sadary[x][y] = true;
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (!sadary[i][j]) {
                    if (isAble(i, j)) {
                        arr.add(new Point(i, j));
                    }
                }
            }
        }
        run(0,0);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }

    static boolean isAble(int x, int y) {
        if ((y < sadary[0].length - 2 && sadary[x][y + 1]) || (y > 0 && sadary[x][y - 1])) {
            return false;
        }
        return true;
    }

    static void run(int index, int count) {
        if (isComplete()) {
            min = Math.min(min, count);
            return;
        }
        if(count >=3){
            return;
        }
        for (int i = index; i < arr.size(); i++) {
            Point point = arr.get(i);
            if (isAble(point.x, point.y)) {
                sadary[point.x][point.y] =true;
                run(i+1,count+1);
                sadary[point.x][point.y] =false;
            }
        }
    }

    static int getDestination(int start) {
        int target = start;
        int n = sadary[0].length;
        for (int i = 0; i < sadary.length; i++) {
            if (target < n && sadary[i][target]) {
                target++;
            } else if (target > 0 && sadary[i][target - 1]) {
                target--;
            }
        }
        return target;
    }

    static boolean isComplete() {
        for (int i = 0; i <= sadary[0].length; i++) {
            if (i != getDestination(i)) {
                return false;
            }
        }
        return true;
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
