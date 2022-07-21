package test;

/**
 *
 * N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
 * 두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
 * 둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
**/


import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr =new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =sc.nextInt();
        }
//        startTime = System.currentTimeMillis();
        solution(n,arr);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }
    static void solution(int n,int[] arr) {
        String result= "NO";
        int target = Arrays.stream(arr).sum();
        if(target%2 == 0){
            if(dfs(arr,0,0,target/2)) result ="YES";
        }
        System.out.print(result);
    }

    static boolean dfs(int[] arr, int index, int sum,int target) {
        if(sum==target) return true;
        if(sum>target) return false;
        for (int i = index; i < arr.length; i++) {
            if (dfs(arr, index + 1, sum + arr[i],target)) {
                return true;
            }
        }
        return false;
    }
    static boolean dfsV2(int[] arr, int index, int sum,int target) {
        if(sum==target) return true;
        if(index+1>=arr.length ||sum>target) return false;
        return dfs(arr,index+1,sum+arr[index],target) || dfs(arr, index + 1, sum, target);
    }
}