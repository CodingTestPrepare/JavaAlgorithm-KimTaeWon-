package test;
/**
 * A,B,C,D,E 총 5명의 학급 후보자들이 출마을때
 * 투표용지의 값을 문자열로 나열한 값이 주어진다.
 * 이때 가장 많은 투표를 받은 후보자를 출력하는 프로그램을 작성
 *
 * 단, 무조건 한명의 당선자만 나오도록 입력이 주어진다.
 * 학급에 수는 5<=N<=50 명이다.
 *
 * 첫번째 줄에는 학급의 수 N이 주어지고
 * 두번쨰 줄에는 투표용지에 적힌 값이 문자열로 주어진다.
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
//        long startTime,finishTime,elapsedTime;
//        startTime= System.currentTimeMillis();
//        solution1(N,str);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);

//        startTime = System.currentTimeMillis();
        solution2(N,str);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }

    /**
     *  오브젝트 정렬 버젼
     */
    static void solution1(int N,String str) {
        candidate[] arr = new candidate[5];
        for (int i = 0; i < 5; i++) {
            arr[i] =new candidate((char) ('A'+i));
        }
        for (char ch : str.toCharArray()) {
            arr[ch - 'A'].count++;
        }
        Arrays.sort(arr);
        System.out.println(arr[0].name);
    }

    /**
     * 해쉬맵 버젼
     */
    static void solution2(int N,String str) {
        HashMap<Character, Integer> hs = new HashMap<>();
        for (char ch : str.toCharArray()) {
            hs.put(ch,hs.getOrDefault(ch,0)+1);
        }
        char result='A';
        for (char ch : hs.keySet()) {
            if (hs.get(result) < hs.get(ch)) {
                result = ch;
            }
        }
        System.out.println(result);
    }
}

class candidate implements Comparable<candidate> {
    int count =0;
    char name ;

    public candidate(char name) {
        this.name = name;
    }
    @Override
    public int compareTo(candidate o) {
        return o.count - this.count ;
    }
}