/**
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 * 단, 1인경우 생략
 * ex) aaabbc ->a3b2c
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }
    static String solution(String str) {
        StringBuilder result =new StringBuilder();
        char[] arr = str.toCharArray();
        int count=1;
        int i;
        for (i = 1; i < arr.length; i++) {
            if(arr[i-1] == arr[i]) count++;
            else{
                result.append(arr[i-1]);
                if(count !=1) result.append(count);
                count=1;
            }
        }
        result.append(arr[i-1]);
        if(count !=1) result.append(count);

        return new String(result);
    }

}