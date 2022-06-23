/**
 *   문자열을 # -> 1 , * -> 0 으로 바꾼후 7단위로 쪼개서 만들어지는 2진수에 대응 되는 char 값을 출력 하라
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