package test;
/**
 * 그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
 *
 * 첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 학생 수는 3 이상 1000 이하이다.
 * 둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.
 * 주어지는 정수는 모두 1 이상 9 이하의 정수이다.
 * 단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int[][] arr =new int[N][5];
        for (int i = 0; i < N; i++) {
            for(int j=0;j<5;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
//        long startTime,finishTime,elapsedTime;
//        startTime= System.currentTimeMillis();
        solution(N,arr);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }
    static void solution(int N, int[][] arr) {
        boolean[][] st =new boolean[N][N];
        int max =-1;
        int index =0;
        int c;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = 0; k < 5; k++) {
                    if(arr[j][k] == arr[i][k]){
                        st[i][j] = st[j][i] =true;
                    }
                }
            }
            c=0;
            for(int j=0;j<N;j++){
                if(st[i][j]) c++;
            }
            if(max < c){
                index =i;
                max =c;
            }
        }
        System.out.println(index+1);
    }
}