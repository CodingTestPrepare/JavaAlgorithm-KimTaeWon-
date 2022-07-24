package test;

/**
 * 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
 * 첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
 */

import java.util.*;

class Main {
    static int[][] mem ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int r= sc.nextInt();
        solution(n,r);
    }
    static void solution(int n ,int r) {
        mem = new int[n + 1][r + 1];
        for (int i = 0; i < r + 1; i++) {
            mem[i][i] =1;
        }
        for (int i = 0; i < n + 1; i++) {
            mem[i][0]=1;
        }
        int combination = combination(n, r);
        System.out.println(combination);
    }

    static int combination(int n, int r) {
        if(mem[n][r] ==0) {
            mem[n][r] = combination(n - 1, r) + combination(n - 1, r - 1);
        }
        return mem[n][r];
    }
}



