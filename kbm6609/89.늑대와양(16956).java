import java.io.*;

/**
 * 백준 문제
 * 16956(늑대와 양)
 * https://www.acmicpc.net/problem/16956
 */
class Main {
    static char[][] arr;
    static int[][] move = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp = br.readLine().split(" ");
        int r = Integer.parseInt(tmp[0]);
        int c = Integer.parseInt(tmp[1]);
        arr = new char[r][];
        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        solution();
        bw.flush();
        bw.close();
    }


    static void solution() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 'W') {
                    if(isAroundWithSheep(i,j)){
                        System.out.println("0");
                        return;
                    }
                }
            }
        }
        System.out.println("1");
        for (char[] i : arr) {
            for (char j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static boolean isAroundWithSheep(int x, int y) {
        int nx, ny;
        for (int i = 0; i < move.length; i++) {
            nx = x + move[i][0];
            ny = y + move[i][1];
            if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[nx].length) {
                if( arr[nx][ny] =='S'){
                    return true;
                }else if(arr[nx][ny] == '.'){
                    arr[nx][ny] = 'D';
                }
            }
        }
        return false;
    }
}
