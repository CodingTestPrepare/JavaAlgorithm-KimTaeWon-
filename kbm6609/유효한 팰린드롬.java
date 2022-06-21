/**
 * 앞에서 읽을 때나 뒤에서 읽을때 같은 문자열 을 팰린드롬 이라 한다.
 * 팰린드롬 이면 yes 아니면 no 를 출력하는 프로그램을 작성하여라.
 * 알파벳 이외의 값은 무시한다.
 * 대소문자는 구분하지않는다.
 * 공백을 포함하지않는다.
 *
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextLine()));
    }

    static String solution(String str) {
        String result = "YES";
        char[] arr =str.replaceAll("[^a-zA-Z]","").toLowerCase().toCharArray();
        for (int i = 0; i < arr.length/2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                result ="NO";
            }
        }
        return result;
    }

}