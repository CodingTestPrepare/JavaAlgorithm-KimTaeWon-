package test;

/**
 * 파스칼 삼각형에서 맨 윗줄의 개수를 N 이라 한다.
 * N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
 * 단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.
 */

import java.util.*;

class Main {
    static int[][] mem ;
    static int[] c;
    static boolean[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        solution(n,m);
    }
    static void solution(int n ,int m) {
        mem = new int[n][n];
        for (int i = 0; i < n; i++) {
            mem[i][i] =1;
            mem[i][0]=1;
        }
        c =new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = combination(n-1,i);
        }
        check =new boolean[n];
        dfs(m,new int[n],0,0,n);
    }
    static boolean dfs(int target,int[] a,int sum,int index,int n){
        if(index == n){
            if(target == sum ){
                for(int i : a){
                    System.out.print(i+" ");
                }
                return true;
            }else {
                return false;
            }
        }
        if(target <= sum){
            return false;
        }
        for(int i=1;i<=n;i++){
            if(!check[i-1]) {
                check[i-1]=true;
                a[index] = i;
                if (dfs(target, a, sum + i * c[index], index + 1, n)) {
                    return true;
                }
                check[i-1]=false;
            }
        }
        return false;
    }
    static int combination(int n, int r) {
        if(mem[n][r] ==0) {
            mem[n][r] = combination(n - 1, r) + combination(n - 1, r - 1);
        }
        return mem[n][r];
    }
}



