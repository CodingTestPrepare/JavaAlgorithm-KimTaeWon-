package test;

import java.io.*;

/**
 * N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰 수로) 원소들의 집합을 찾는 프로그램을 작성하라.
 * 예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7, 12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어
 * 길이가 5인 최대 부분 증가수열을 만들 수 있다.
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        solution(n, arr);
    }

    static void solution(int n, int[] arr) {
        int[] result = new int[n];
        result[0] = 1;
        int tmpMax;
        int max = 0;
        for (int i = 1; i < n; i++) {
            tmpMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    tmpMax = Math.max(tmpMax, result[j]);
                }
            }
            result[i] = tmpMax + 1;
            max = Math.max(result[i],max);
        }

        System.out.println(max);
    }

}