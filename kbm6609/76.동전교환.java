import java.io.*;
import java.util.Arrays;

/**
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
 * 각 단위의 동전은 무한정 쓸 수 있다.
 * 입력
 * 첫 번째 줄에는 동전의 종류개수 N(1<=N<=50)이 주어진다.
 * 두 번째 줄에는 N개의 동전의 종류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
 * 각 동전의 종류는 100원을 넘지 않는다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[1];
        for (int i = 0; i < str.length; i++) {
            str[i] = br.readLine();
        }
        int m = Integer.parseInt(br.readLine());
//        solution1(str, n, m);
        solution2(str, n, m);
    }

    /**
     * Version 1
     * dp 개념을 사용해서 i원의 거스름돈을 줘야할 떄 필요한 동전의 개수를 i-j, j 원을 거슬러 줄때 필요한 동전의 개수 들중 가장 작은 값으로 선정하여 뽑는 방식이다.
     * 초반에 동전의 종류 a, b ,c .. 원 동전이 주어 지면 coins[a], coins[b], coins[c] ... 의 값을 1 로 설정하여 시작하면 원하는 결과를 얻을수가 있다.
     */
    static void solution1(String[] str, int n, int m) {
        String[] s = str[0].split(" ");
        int[] coins = new int[m + 1];
        for (int i = 0; i < s.length; i++) {
            coins[Integer.parseInt(s[i])] = 1;
        }
        int pre = 0;
        for (int i = 1; i < coins.length; i++) {
            pre = Integer.MAX_VALUE;
            if (coins[i] == 0) {
                for (int j = 1; j <= i - j; j++) {
                    if (coins[j] != Integer.MAX_VALUE && coins[i - j] != Integer.MAX_VALUE) {
                        pre = Math.min(pre, coins[j] + coins[i - j]);
                    }
                }
                coins[i] = pre;
            }

        }
        System.out.println(coins[m]);
    }

    /**
     * Version 2 (best)
     * Knapsack 방식으로 구현한 버젼이다.
     *
     *
     */
    static void solution2(String[] str, int n, int m) {
        String[] s = str[0].split(" ");
        int[] coins = new int[n];
        int[] result = new int[m + 1];
        for (int i = 0; i < s.length; i++) {
            coins[i] = Integer.parseInt(s[i]);
        }
        Arrays.fill(result,501);
        result[0] =0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < result.length; j++) {
                result[j] = Math.min(result[j], result[j - coins[i]] + 1);
            }
        }
        System.out.println(result[m]);
    }
}

