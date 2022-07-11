package test;

/**
 * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 *
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
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
        int f=0;
        String result ="YES";
        for (char ch : str.toCharArray()) {
            if(ch == '('){
                f++;
            }
            else{
                f--;
                if(f<0) break;
            }
        }
        if(f!=0) {
            result ="NO";
        }
        System.out.println(result);
    }
}
