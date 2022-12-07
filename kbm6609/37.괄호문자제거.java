package test;

/**
 * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 *
 *  첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 *  남은 문자만 출력한다.
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str =sc.next();
//        startTime = System.currentTimeMillis();
        solution(str);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }

    static void solution(String str) {
        int f= 0;
        StringBuilder stb =new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                f++;
            }else if (ch == ')'){
                f--;
            }else{
                if(f ==0 ){
                    stb.append(ch);
                }
            }
        }
        System.out.println(stb);
    }
}
