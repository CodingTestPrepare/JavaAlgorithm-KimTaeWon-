/**
 *  한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 *  문장속의 각 단어는 공백으로 구분됩니다.
 *  첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.
 **/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str =br.readLine().split(" ");
        int c = -1;
        String result="";
        int len ;
        for (String i : str) {
            len =i.length();
            if (len > c) {
                c =len;
                result =i;
            }
        }
        bw.write(result);
        bw.flush();
        bw.close();
    }
}

