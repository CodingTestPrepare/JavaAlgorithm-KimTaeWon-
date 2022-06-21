/**
 * 문자열이 주어지면 그 중 숫자만 추출하여 자연수를 만들어서 출력하시오
 * 만들수있는 자연수는 100,000,000 을 넘지 않습니다.
 * 문자열의 길이는 100을 넘지 않습니다.
 * ex) qwe2q234jjj5 => 22345
 *
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextLine()));
    }
    static int solution(String str) {
        return Integer.parseInt(str.replaceAll("[^0-9]",""));
    }

}