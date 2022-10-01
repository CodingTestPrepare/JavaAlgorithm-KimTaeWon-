import java.io.*;

/**
 *  계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는
 * 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.
 * 그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?
 * n<=35
 */
class Main {
    static long[] fac = new long[12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution1(n);
    }

    /**
     * Version1
     * 중복 조합 공식을 활용한 방식
     * 중복 조합공식을 그대로 사용하면 long 최대 범위를 초과 하는 문제가 발생하여
     * 공식을 약간 수정하였다.
     */
    static void solution1(int n) {
        long result = 0;
        fac[0] = 1;
        fac[1] = 1;
        for (int i = 2; i < 12; i++) {
            fac[i] = fac[i - 1] * i;
        }
//        1   2   3   4   5   6   8   7   9   10  11  12  13  14  15  16 ;
//        31  29  27  25  23  21  19  17  15  13  11  9   7   5   3   1
        int[] arr = new int[2];
        arr[0] = n / 2;
        arr[1] = n % 2;
        int c = arr[0] + arr[1];
        while (arr[0] >= 0) {
            long i = calNum(arr, c);
//            System.out.println(i);
            result += i;
            arr[0]--;
            arr[1] += 2;
            c++;
        }
        System.out.println(result);

    }


    static long calNum(int[] arr, int c) {
        long result = 1;
        int minIndex = 0, maxIndex = 1;
        if (arr[0] > arr[1]) {
            minIndex = 1;
            maxIndex = 0;
        }
        for (int i = c; i > arr[maxIndex]; i--) {
            result *= i;
        }
        return result / fac[arr[minIndex]];
    }

    /**
     * Version2 (best)
     * dp 를 사용는 방식
     */
    static void solution2(int n) {
        int result = 0;
        int[] dy = new int[36];
        dy[1] = 1;
        dy[2] = 2;
        System.out.println(dyMethod(dy,n));
    }

    static int dyMethod(int[] dy, int target) {
        if (dy[target] != 0) {
            return dy[target];
        }
        return dy[target] = dyMethod(dy, target - 1) + dyMethod(dy, target - 2);
    }
}