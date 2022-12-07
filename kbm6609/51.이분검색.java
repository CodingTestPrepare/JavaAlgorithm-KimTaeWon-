package test;

/**
 *
 * 임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
 * 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.
**/


import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        int[]arr =new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }
//        startTime = System.currentTimeMillis();
        solution(n,m,arr);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }

    static void solution(int n,int m, int[] arr) {
        Arrays.sort(arr);
        int start =0;
        int end = n;
        while(true){
            if(m ==arr[(end+start)/2]){
                break;
            }else if(m<arr[(end+start)/2]){
                end = (end+start)/2;
            }else {
                start = (end+start)/2+1;
            }
        }
        System.out.println((end+start)/2+1);
    }
}
