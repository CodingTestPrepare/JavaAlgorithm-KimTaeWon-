import java.io.*;
import java.util.ArrayList;

/**
 * 첫줄에 n m 을 알려준다( n 도시의 크기 , m 남기는 피자집수 )
 * 두번쨰 줄에 n*n 크기의 도시의 정보를 알려준다.
 * (0 : 빈칸 , 1 : 집 , 2 : 피자집)
 * 집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.
 * 도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.
 * 시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.
 * 도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.
 */
public class Solution {
    static ArrayList<House> hs = new ArrayList<>();
    static ArrayList<Pizza> pz = new ArrayList<>();
    static int[] choicePizza;
    static int c = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            tmp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int solution = solution(arr, m);
        System.out.println(solution);
//        System.out.println("c " + c);
    }

    static int solution(int[][] arr, int m) {
        choicePizza = new int[m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1) {
                    hs.add(new House(i, j));
                } else if (arr[i][j] == 2) {
                    pz.add(new Pizza(i, j));
                }
            }
        }
        int pzSize = pz.size();
        for (House i : hs) {
            i.pizzaDistance = new int[pzSize];
            for (int j = 0; j < pzSize; j++) {
                i.pizzaDistance[j] = Math.abs(i.x - pz.get(j).x) + Math.abs(i.y - pz.get(j).y);
            }
        }
        return run(0, 0, m, 0);
    }

    static int run(int index, int count, int m, int digit) {
        if (count == m) {
            c++;
            int sum = 0;
            int t = 0;
            for (int i = 0; i < index; i++) {
                if ((digit & (1 << i)) > 0) {
                    choicePizza[t++] = i;
                }
            }
            int ms = 0;
            for (int i = 0; i < hs.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j : choicePizza) {
                    if (tmp > hs.get(i).pizzaDistance[j]) {
                        tmp = Math.min(tmp, hs.get(i).pizzaDistance[j]);
                        ms = hs.get(i).pizzaDistance[j];
                    }
                }
                sum += tmp;
            }
            return sum;
        }
        if (index == pz.size()) {
            return Integer.MAX_VALUE;
        }
        return Math.min(run(index + 1, count + 1, m, digit | 1 << index), run(index + 1, count, m, digit));

    }
}

class House {
    int x, y;
    int[] pizzaDistance;

    public House(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Pizza {
    int x, y;

    public Pizza(int x, int y) {
        this.x = x;
        this.y = y;
    }
}