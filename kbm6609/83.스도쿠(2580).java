import java.io.*;
import java.util.*;

/**
 * 백준 문제
 * 2580(스도쿠)
 * https://www.acmicpc.net/problem/2580
 */
public class Main {
    static int[] block = new int[9];
    static int[] row = new int[9];
    static int[] col = new int[9];
    static int[][] sdoku = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                sdoku[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        solution1();
    }

    static void solution1() {
        int blockIndex = 0;

        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            blockIndex = (i / 3) * 3;
            for (int j = 0; j < 9; j++) {
                if (sdoku[i][j] != 0) {
                    int num = sdoku[i][j] - 1;
                    block[blockIndex + (j / 3)] |= 1 << num;
                    row[i] |= 1 << num;
                    col[j] |= 1 << num;
                } else {
                    points.add(new Point(i, j));
                }
            }
        }
        boolean b = searchNum(0, points);
        for (int[] ints : sdoku) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    static boolean searchNum(int index, ArrayList<Point> points) {
        if (index >= points.size()) {
            return true;
        }
        Point point = points.get(index);
        int check = block[(point.x / 3) * 3 + point.y / 3] | row[point.x] | col[point.y];
        for (int i = 0; i < 9; i++) {
            if ((check & (1 << i)) == 0) {
                sdoku[point.x][point.y] = i + 1;
                block[(point.x / 3) * 3 + point.y / 3] |= 1 << i;
                row[point.x] |= 1 << i;
                col[point.y] |= 1 << i;
                if (searchNum(index + 1, points)) {
                    return true;
                } else {
                    sdoku[point.x][point.y] = 0;
                    block[(point.x / 3) * 3 + point.y / 3] &= ~(1 << i);
                    row[point.x] &= ~(1 << i);
                    col[point.y] &= ~(1 << i);
                }
            }
        }
        return false;
    }
}

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

