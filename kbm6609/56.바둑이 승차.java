package test;

/**
 * 철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
 * 철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
 * N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.
 **/

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        int[] arr =new int[m];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =sc.nextInt();
        }
//        startTime = System.currentTimeMillis();
        solution(n,m,arr);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }
    static void solution(int n,int m,int[] arr) {
        System.out.println(dfs(arr,0,0,n));
    }

    static int dfs(int[] arr, int sum, int index, int n) {
        if(sum>n){
            return -1;
        }
        if (index == arr.length) {
            return sum;
        }
        return Math.max(dfs(arr, sum, index + 1, n),dfs(arr,sum+arr[index],index+1,n));
    }

}