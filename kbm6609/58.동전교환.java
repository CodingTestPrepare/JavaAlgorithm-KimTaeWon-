package test;

/**
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
 * 첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
 * 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.
 */

import java.util.*;

class Main {
    static Integer[] arr;
    static int target;
    static int count = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =sc.nextInt();
        }
        target =sc.nextInt();
        solutionBfs();
    }
    static void solutionBfs() {
        Queue<Integer> qu =new LinkedList<>();
        Arrays.sort(arr,Collections.reverseOrder());
        int len;
        int c =0;
        qu.add(0);
        lf : while (!qu.isEmpty()) {
            len = qu.size();
            for (int i = 0; i < len; i++) {
                Integer poll = qu.poll();
                if(poll == target){
                    break lf;
                }
                for(int j: arr){
                    qu.add(poll+j);
                }
            }
            c++;
        }
        System.out.println(c);
    }
    static void solutionDfs() {
        Arrays.sort(arr,Collections.reverseOrder());
        dfs(0,0);
        System.out.println(count);
    }

    static void dfs(int c, int sum) {
        System.out.println("c");
        if(count <= c || sum>target){
            return;
        }
        if (sum == target) {
            count = Math.min(count, c);
            return;
        }
        for (int i : arr) {
            dfs(c + 1, sum + i);
        }
    }
}



