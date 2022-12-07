import java.io.*;
import java.util.ArrayList;

/**
 * 모든 도시를 연결하도록 도로을 연결할떄 최소 비용을 구하여라
 * 첫번째줄에 도시의수(V) ,도로의 수(E) 가 주어지고
 * 두번째 줄 부터 E 개의 도시 도시 비용 값이 주어진다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int v = Integer.parseInt(tmp[0]);
        int e = Integer.parseInt(tmp[1]);
        String[] str = new String[e];
        for (int i = 0; i < str.length; i++) {
            str[i] = br.readLine();
        }
        solution1(str, v, e);
    }


    static void solution1(String[] str, int v, int e) {
        ArrayList<CityEdge> edge = new ArrayList<>();
        int[] arr = new int[v + 1];
        int result = 0;
        int count=0;
        for (int i = 0; i < str.length; i++) {
            String[] tmp = str[i].split(" ");
            edge.add(new CityEdge(Integer.parseInt(tmp[2]), Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])));
        }
        edge.sort(CityEdge::compareTo);
        for (int i = 0; i < edge.size(); i++) {
            CityEdge cityEdge = edge.get(i);
            if (!isSameSet(cityEdge.c1, cityEdge.c2, arr)) {
                union(cityEdge.c1, cityEdge.c2, arr);
                result += cityEdge.val;
                count++;
                if(count == v-1){
                    break;
                }
            }
        }
        System.out.println(result);
    }

    static void union(int a, int b, int[] arr) {
        int aRoot = findRoot(a, arr);
        int bRoot = findRoot(b, arr);
        if (aRoot != bRoot) arr[bRoot] = aRoot;
    }

    static int findRoot(int a, int[] arr) {
        if (arr[a] == 0) {
            return a;
        }
        return arr[a] = findRoot(arr[a], arr);
    }

    static boolean isSameSet(int c1, int c2, int[] arr) {
        return findRoot(c1, arr) == findRoot(c2, arr);
    }

}

class CityEdge implements Comparable<CityEdge> {
    int val;
    int c1, c2;

    public CityEdge(int val, int c1, int c2) {
        this.val = val;
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public int compareTo(CityEdge o) {
        return this.val - o.val;
    }
}


