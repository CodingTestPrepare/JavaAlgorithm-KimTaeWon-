package test;

/**
 * 현수네 반에는 N명의 학생들이 있습니다.
 * 선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 했습니다.
 * 만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,
 * N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요
 **/

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
        HashSet<Integer> hs = new HashSet<>();
        char ch ='U';
        for (int i : arr) {
            if (hs.contains(i)) {
                ch='D';
                break;
            }
            hs.add(i);
        }
        System.out.println(ch);
    }
}
