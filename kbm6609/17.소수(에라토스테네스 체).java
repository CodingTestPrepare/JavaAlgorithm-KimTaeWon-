/**
 *  자연수 N 이 주어지면  1~N 까지의 소수의 개수를 출력하시오
 *
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();

        solution(N);
    }
    static void solution(int N) {
        boolean[] noPrime = new boolean[N + 1];
        int count =0;
        for (int i = 2; i <= N/2; i++) {
            if(!noPrime[i]) {
                toEra(noPrime, i);
            }
        }
        for (int i = 2; i <= N; i++) {
            if(!noPrime[i]) count++;
        }
        System.out.println(count);
    }

    static int toEra(boolean[] noPrime, int index) {
        int count = 0;
        for (int i = 2; index * i < noPrime.length; i++) {
            noPrime[i*index] =true;
        }
        return count;
    }
}