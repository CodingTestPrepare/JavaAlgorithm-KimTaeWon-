package test;

/**
 *N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
 * 현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
 * 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
 * C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.
 *
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
        int answer = 0;
        int start,end;
        int index;
        start = 1;
        Arrays.sort(arr);
        end = Arrays.stream(arr).max().getAsInt();
        while(start<=end){
            index = (start + end) / 2;
            if(count(arr,index)>=m){
                start = index +1;
                answer = index;
            }else{
                end = index - 1;
            }
        }

        System.out.println(answer);
    }
    static int count(int[] arr,int index){
        int cnt = 1;
        int endPoint = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - endPoint >= index) {
                endPoint = arr[i];
                cnt++;
            }
        }
        return cnt;
    }
}
