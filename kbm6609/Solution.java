package test;
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
        int length =sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println(solution(s,length));
    }
    static String solution(String str,int length) {
        StringBuilder result =new StringBuilder();
        StringBuilder tmp =null;
        String s = str.replaceAll(" ","").replaceAll("#", "1").replaceAll("\\*", "0");
        int len =s.length();
        for(int i=0;i<len;i++){
            if(i%7==0){
                if(tmp !=null){
                    result.append(Character.toChars(Integer.parseInt(new String(tmp),2)));
                }
                tmp =new StringBuilder();
            }
            tmp.append(s.charAt(i));
        }
        result.append(Character.toChars(Integer.parseInt(new String(tmp),2)));
        return new String(result);
    }
}