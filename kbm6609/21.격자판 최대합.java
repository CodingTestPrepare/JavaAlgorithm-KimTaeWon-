package test;
/**
 *  N*N 격자판의 값들중 2개의 대각선과 각 열,행 의 합들중 가장 큰 값을 구하시오
 *
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =10000;
        int[][] arr =new int[N][N];
        for (int i = 0; i < N; i++) {
            for(int j=0;j<N;j++) {
                arr[i][j] = i;
            }
        }
        long startTime,finishTime,elapsedTime;

        System.out.println("\n0");
        startTime= System.currentTimeMillis();
        solution0(N,arr);
        finishTime = System.currentTimeMillis();
        elapsedTime = finishTime - startTime;
        System.out.println("elapsedTime(ms) : " + elapsedTime);

    }
    /**
     *  내가 만든 코드
     *  단점 :
     *      1. 열의 합을 구할때 배열을 이용햇기 떄문에 쓸대없는 메모리 낭비를 했다 .
     *      2. 열의 합 배열중 가장 큰값을 구할때 반복문을 한번더 돌리기 때문에 시간 낭비를 했다.
     *      결과적으로 시간소요는 따로 반복문 돌리는게 더빠르다 , 즉 1번 단점만 존재 2번은 아니다.
     *  궁금증 :
     *      1. 대각선을 구할때 O(N^2) 시간복잡도를 갖는 반복문 안에서 if 문을 사용하여 구했는데
     *          이게 따로 O(N) 시간을 갖는 반복문으로 빼서 따로 구하는게 더 빠를까?
     *      결과 : 대각선은 따로 빼는게 더 빠르다
     *
     *      2. Math.max , 삼항연산자 , if () A =B 이것들중 누가 제일 빠른가
     *      결과 : if 문이 제일 느리고 나머지 두개는 비슷하다.
     *
     *      3. 0,1 이 나머지보다 훨씬 빠른데 그 이유는?
     *      결과 : a[i][j] 를 순차 접근할때 한 행씩 접근하는게 한 열씩 순회 하는것보다 훠~~~~~~~~~~얼~~~~~씬 빠르다.
     *              그래서 나머지 부분들이 0,1보다 훨씬 느린거다
     *
     *
     */
    static void solution1(int N,  int[][] arr) {
        int result =0;
        int[] rowSum =new int[N];
        int sum;
        int[] crossSum=new int[2];
        for (int i = 0; i < N; i++) {
            sum=0;
            for (int j = 0; j < N; j++) {
                rowSum[j] += arr[i][j];
                sum += arr[i][j];
                if(i==j) crossSum[0] += arr[i][j];
                if(N-1-i ==j)crossSum[1] +=arr[i][j];
            }
            result = sum > result ? sum :result;
        }
        for (int i = 0; i < N; i++) {
            if(rowSum[i] > result) result =rowSum[i] ;
        }
        crossSum[0] = crossSum[0] > crossSum[1] ? crossSum[0] : crossSum[1];
        result = result < crossSum[0] ? crossSum[0] : result;
        System.out.println(result);
    }

    static void solution0(int N,  int[][] arr) {
        int result =0;
        int[] rowSum =new int[N];
        int sum;
        int[] crossSum=new int[2];
        for (int i = 0; i < N; i++) {
            sum=0;
            for (int j = 0; j < N; j++) {
                rowSum[j] += arr[i][j];
                sum += arr[i][j];
            }
            result = Math.max(sum,result);
        }
        for(int i =0;i<N;i++){
            result = Math.max(rowSum[i],result);
        }
        for (int i = 0; i < N; i++) {
            crossSum[0] += arr[i][i];
            crossSum[1] += arr[N-1-i][i];
        }
        result = Math.max(crossSum[0],result);
        result = Math.max(crossSum[1],result);
        System.out.println(result);
    }
    /**
     *  기존 작성 코드에서 불필요한 코드를 보완한 코드이다.
     *
     */

    // 대각선 내부에서 구하기
    static void solution2(int N,  int[][] arr) {
        int result =0;
        int rowSum;
        int colSum;
        int[] crossSum=new int[2];
        for (int i = 0; i < N; i++) {
            colSum = 0;
            rowSum = 0;
            for (int j = 0; j < N; j++) {
                rowSum += arr[j][i];
                colSum += arr[i][j];
                if(i==j) crossSum[0] += arr[i][j];
                if(N-1-i ==j)crossSum[1] +=arr[i][j];
            }
            result = Math.max(result,Math.max(rowSum,colSum));

        }
        result = Math.max(result,Math.max(crossSum[0],crossSum[1]));
        System.out.println(result);
    }
    //외부에서 대각선 구하기
    static void solution3(int N,  int[][] arr) {
        int result =0;
        int rowSum;
        int colSum;
        int[] crossSum=new int[2];
        for (int i = 0; i < N; i++) {
            colSum = 0;
            rowSum =0;
            for (int j = 0; j < N; j++) {
                rowSum += arr[j][i];
                colSum += arr[i][j];
            }
            result = Math.max(result,Math.max(rowSum,colSum));
        }
        for (int i = 0; i < N; i++) {
            crossSum[0] += arr[i][i];
            crossSum[1] += arr[N-1-i][i];
        }
        result = Math.max(result,Math.max(crossSum[0],crossSum[1]));
        System.out.println(result);
    }
    //수정본 + 내부 대각선 구하기 + 최대값 Math.max 사용하지않은 버젼
    static void solution4(int N,  int[][] arr) {
        int result =0;
        int rowSum;
        int colSum;
        int[] crossSum=new int[2];
        for (int i = 0; i < N; i++) {
            colSum = 0;
            rowSum = 0;
            for (int j = 0; j < N; j++) {
                rowSum += arr[j][i];
                colSum += arr[i][j];
                if(i==j) crossSum[0] += arr[i][j];
                if(N-1-i ==j)crossSum[1] +=arr[i][j];
            }
            result = rowSum > result ? rowSum :(colSum > result ? colSum : result);
        }
        result = crossSum[0] > result ? crossSum[0] :(crossSum[1] > result ? crossSum[1] : result);
        System.out.println(result);
    }
    //수정본 + 대각선 외부에서 구하기 + Math.max 사용하지않은 버젼
    static void solution5(int N,  int[][] arr) {
        int result =0;
        int rowSum;
        int colSum;
        int[] crossSum=new int[2];
        for (int i = 0; i < N; i++) {
            colSum = 0;
            rowSum =0;
            for (int j = 0; j < N; j++) {
                rowSum += arr[j][i];
                colSum += arr[i][j];
            }
            result = rowSum > result ? rowSum :(colSum > result ? colSum : result);
        }
        for (int i = 0; i < N; i++) {
            crossSum[0] += arr[i][i];
            crossSum[1] += arr[N-1-i][i];
        }
        result = crossSum[0] > result ? crossSum[0] :(crossSum[1] > result ? crossSum[1] : result);
        System.out.println(result);
    }
}