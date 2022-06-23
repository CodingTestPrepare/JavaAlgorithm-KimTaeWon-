/**
 *  A와 B 가 가위 바위 보를 하엿을때 이긴 사람을 출력하는 프로그램을 작성
 *  비기면 D , A 가 이기면 A ,B 가 이기면 B 를 출력
 *  첫 줄엔 게임 횟수 , 두번째 줄엔 A가 낸 정보 , 세 번째 줄엔 B 가 낸 정보가 들어있다.
 *  각 배열에는 1 : 가위 ,2 : 바위 ,3 : 보 가 들어있다.
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int[] A =new int[N];
        int[] B =new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i]=sc.nextInt();
        }
        for (int i = 0; i < B.length; i++) {
            B[i]=sc.nextInt();
        }
        solution(A,B, N);
    }
    static void solution(int[] A,int[] B, int N) {
        for (int i = 0; i < N; i++) {
            if(A[i]==B[i]){
                System.out.println("D");
            }else if(A[i]%3 == B[i]-1){
                System.out.println("B");
            }else {
                System.out.println("A");
            }
        }
    }
}