package test;

/**
 * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 *
 * 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
 * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다
 */

import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t =sc.next();
//        startTime = System.currentTimeMillis();
        solution(s,t);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }

    static void solution(String s, String t) {
        HashMap<Character ,Integer> hs =new HashMap<>();
        for (char ch : t.toCharArray()) {
            hs.put(ch,hs.getOrDefault(ch,0)+1);
        }

        char[] cstr = s.toCharArray();
        int k = t.length();
        int result =0;
        for (int i = 0; i < cstr.length; i++) {
            if (hs.size() == 0) {
                result++;
            }
            if(i-k>=0) {
                hs.put(cstr[i-k],hs.getOrDefault(cstr[i-k],0)+1);
                if(hs.get(cstr[i-k])==0) hs.remove(cstr[i - k]);
            }
            hs.put(cstr[i],hs.getOrDefault(cstr[i],0)-1);
            if(hs.get(cstr[i])==0) hs.remove(cstr[i]);

        }
        if (hs.size() == 0) {
            result++;
        }
        System.out.println(result);
    }
}
