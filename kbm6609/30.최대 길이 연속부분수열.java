/**
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 * 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
 * 두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }
//        long startTime,finishTime,elapsedTime;
//        startTime= System.currentTimeMillis();
        solution(N,K,arr);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }
    static void solution(int N,int K ,int[] arr) {
        int result = 0;
        int front=-1;
        int end =-1;
        for (int i = 0; i < N; i++) {
           if(arr[i] ==1){
               if(front ==-1){
                   front =i;
                   end = front+1;
               }else{
                   end++;
               }
           }else{
               if (K == 0) {
                   result= Math.max(result, end- front);
                   while(front < end){
                       if (arr[front++] == 2) {
                           K++;
                           break;
                       }
                   }
               }
               if(K>0) {
                   K--;
                   arr[i] = 2;
                   end++;
               }
           }
        }
        result= Math.max(result, end- front);
        System.out.println(result);
    }
}