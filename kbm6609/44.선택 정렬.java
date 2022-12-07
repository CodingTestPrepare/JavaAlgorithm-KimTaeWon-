package test;

/**
 * N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 * 정렬하는 방법은 선택정렬입니다.
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr =new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =sc.nextInt();
        }
//        startTime = System.currentTimeMillis();
        solution(n,arr);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }

    static void solution(int n, int[] arr) {
        int minIndex=0;
        for (int i = 0; i < n; i++) {
            minIndex=i;
            for (int j = i + 1; j < n; j++) {
                if(arr[minIndex] > arr[j]) minIndex=j;
            }
            int tmp =arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] =tmp;
            System.out.print(arr[i]+" ");
        }
    }
}

