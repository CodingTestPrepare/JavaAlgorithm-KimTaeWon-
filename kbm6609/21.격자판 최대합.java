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

        System.out.println("\n직접 작성");
        startTime= System.currentTimeMillis();
        solution1(N,arr);
        finishTime = System.currentTimeMillis();
        elapsedTime = finishTime - startTime;

        System.out.println("elapsedTime(ms) : " + elapsedTime);


        System.out.println("\n수정본 (대각선 내부에서 구함)");
        startTime= System.currentTimeMillis();
        solution2(N,arr);
        finishTime = System.currentTimeMillis();
        elapsedTime = finishTime - startTime;

        System.out.println("elapsedTime(ms) : " + elapsedTime);


        System.out.println("\n수정본 (대각선 외부에서 구함)");
        startTime= System.currentTimeMillis();
        solution3(N,arr);
        finishTime = System.currentTimeMillis();
        elapsedTime = finishTime - startTime;

        System.out.println("elapsedTime(ms) : " + elapsedTime);


        System.out.println("\n수정본 (대각선 내부에서 구함 + Math.max 안씀)");
        startTime= System.currentTimeMillis();
        solution4(N,arr);
        finishTime = System.currentTimeMillis();
        elapsedTime = finishTime - startTime;
        System.out.println("elapsedTime(ms) : " + elapsedTime);

        System.out.println("\n수정본 (대각선 외부에서 구함 + Math.max 안씀)");
        startTime= System.currentTimeMillis();
        solution5(N,arr);
        finishTime = System.currentTimeMillis();
        elapsedTime = finishTime - startTime;

        System.out.println("elapsedTime(ms) : " + elapsedTime);
    }
    /**
     *  내가 만든 코드
     *  단점 :
     *      1. 열의 합을 구할때 배열을 이용햇기 떄문에 쓸대없는 메모리 낭비를 했다 .
     *      2. 열의 합 배열중 가장 큰값을 구할때 반복문을 한번더 돌리기 때문에 시간 낭비를 했다.
     *
     *  궁금증 :
     *      1. 대각선을 구할때 O(N^2) 시간복잡도를 갖는 반복문 안에서 if 문을 사용하여 구했는데
     *          이게 따로 O(N) 시간을 갖는 반복문으로 빼서 따로 구하는게 더 빠를까?
     *      결과 : 직접구현 , 수정본2개(대각선 외부, 내부 구현) 테스트 결과 직접 작성이 훨씬 빠른 속도를 보인다.
     *              1<3<2 의 실행 시간을 보인다.
     *      해석 : 확인해본 결과 1,2 는 열 구하는 부분과 최대값을 Math.max로 하냐 삼항 연산자로 하냐 차이 말고는 동일 하다,
     *              열을 구하는건 2번이 더 효율적 일거 같은데 시간 차이가 나는 걸보면 Math.max가 함수이기 때문에 그런거같다.
     *              이를 확인 하기 위해 Math.max를 사용하지않은 2의 개조 버젼인 4, 3의 Math.max를 사용하지않는 버전 5를 만들어봐야겟다.
     *
     * 결과
     * 1<<3<<2<<<<4<<<<5 와 같은 양상을 보인다 .
     * 1 을 Math.max 로 바꾼 0 버젼과 1버젼의 실행시간 차이가 나지않는걸보아 저 문제는 아닌거같다.
     * Math.max( A ,MAth.max(B,C) ) 를 사용하는것과 2줄로 만든것의 차이도 보이지않는다.
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
                if(i==j) crossSum[0] += arr[i][j];
                if(N-1-i ==j)crossSum[1] +=arr[i][j];
            }
            result = Math.max(sum,result);
        }
        for (int i = 0; i < N; i++) {
            if(rowSum[i] > result) result =rowSum[i] ;
        }
       for (int i = 0; i < N; i++) {
           crossSum[0] += arr[i][i];
           crossSum[1] += arr[N-1-i][i];
       }
       crossSum[0] =  Math.max(crossSum[0],crossSum[1]);
        result = Math.max(crossSum[0],result);
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