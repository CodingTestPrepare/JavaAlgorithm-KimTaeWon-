
/**
 * 문자열 의 중복을 제거하고 출력하는 프로그램 작성
 *  중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 *
 */

import java.io.*;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Character> set =new HashSet<>();
        String str =br.readLine();
        for (char ch : str.toCharArray()) {
            if (!set.contains(ch)) {
                set.add(ch);
                bw.write(ch);
            }
        }
        bw.flush();
        bw.close();
    }

}

