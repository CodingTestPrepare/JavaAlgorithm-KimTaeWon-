import java.io.*;

/**
 * 반 학생은 N명이다. 각 학생들의 친구관계를 알고 싶다.
 * 모든 학생은 1부터 N까지 번호가 부여되어 있고, 각각 두 명의 친구 관계가 번호로 표현된 숫자쌍이 주어진다.
 * 만약 (1, 2), (2, 3), (3, 4)의 숫자쌍이 주어지면 1번 학생과 2번 학생이 친구이고, 2번 학생과 3번 학생이 친구, 3번 학생과 4번 학생이 친구이다.
 * 그리고 1번 학생과 4번 학생은 2번과 3번을 통해서 친구관계가 된다.
 * 숫자쌍이 주어지면 특정 두 명이 친구인지를 판별하는 프로그램을 작성하세요.
 * 두 학생이 친구이면 “YES"이고, 아니면 ”NO"를 출력한다.
 * 첫 번째 줄에 반 학생수인 자연수 N(1<=N<=1,000)과 숫자쌍의 개수인 M(1<=M<=3,000)이 주어지고,
 * 다음 M개의 줄에 걸쳐 숫자쌍이 주어진다.
 * 마지막 줄에는 두 학생이 친구인지 확인하는 숫자쌍이 주어진다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        String[] str = new String[m + 1];
        for (int i = 0; i < m + 1; i++) {
            str[i] = br.readLine();
        }
        solution1(str, n, m);
    }


    static void solution1(String[] str, int n, int m) {
        int[] arr = new int[n + 1];
        String[] tmp;
        int a, b;
        for (int i = 0; i < m; i++) {
            tmp = str[i].split(" ");
            a = Integer.parseInt(tmp[0]);
            b = Integer.parseInt(tmp[1]);
            union(a, b, arr);
        }
        tmp = str[m].split(" ");
        a = Integer.parseInt(tmp[0]);
        b = Integer.parseInt(tmp[1]);
        if (findFiend(a, b, arr)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static void union(int a, int b, int[] arr) {
        int aRoot = findRoot(a, arr);
        int bRoot = findRoot(b, arr);
        if (aRoot != bRoot) arr[bRoot] = aRoot;
    }

    static boolean findFiend(int a, int b, int[] arr) {
        int bRoot = findRoot(b, arr);
        int aRoot = findRoot(a, arr);
        return aRoot == bRoot;
    }

    static int findRoot(int a, int[] arr) {
        if (arr[a] == 0) {
            return a;
        }
        return arr[a] = findRoot(arr[a], arr);
    }

}


