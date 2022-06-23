/**
 *  첫줄에 자연수 N 이 입력된다.
 *  두번째 줄에 N 개의 0또는 1이 입력된다.
 *  1은 정답 , 0은 오답이고
 *  연속적으로 정답인 경우엔 연속됫횟수 만큼의 점수를 얻는다.
 *  예 ) 11100101 -> 1점,2점,3점,0점,0점,1점,0점,1점
 *
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int[] arr =new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }
        solution(N,arr);
    }
    static void solution(int N, int[] arr) {
        int count = 0;
        int point=0;
        for (int i : arr) {
            if(i ==1) point+=++count;
            else count =0;
        }
        System.out.println(point);
    }
}