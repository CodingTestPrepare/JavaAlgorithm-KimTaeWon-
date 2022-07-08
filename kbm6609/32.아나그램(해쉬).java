package test;
/**
 * Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
 * 예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
 * 알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
 * 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
 * 첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다.
 * 두 단어가 아나그램이면 “YES"를 출력하고, 아니면 ”NO"를 출력합니다.
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 =sc.next();
        String str2 = sc.next();
//        long startTime,finishTime,elapsedTime;
//        startTime= System.currentTimeMillis();
//        solution1(N,str);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);

//        startTime = System.currentTimeMillis();
        solution(str1,str2);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }

    static void solution(String str1,String str2) {
        HashMap<Character, Integer> hs = new HashMap<>();
        String result="YES";
        for (char ch : str1.toCharArray()) {
            hs.put(ch,hs.getOrDefault(ch,0)+1);
        }
        for (char ch : str2.toCharArray()) {
            if(hs.containsKey(ch)){
                hs.put(ch, hs.get(ch) - 1);
                if(hs.get(ch) ==0){
                    hs.remove(ch);
                }
            }else{

                result ="NO";
                break;
            }
        }
        if(hs.size() !=0){
            result ="NO";
        }

        System.out.println(result);
    }
}
