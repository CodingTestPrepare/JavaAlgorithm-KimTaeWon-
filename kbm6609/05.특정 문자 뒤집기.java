package test;

/**
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 **/

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = br.readLine().toCharArray();

        int s=0,e=arr.length-1;
        while(true){
            while(s<e && !isap(arr[s])) {
                s++;
            }
            while(e>s && !isap(arr[e])) {
                e--;
            }
            if(s>=e){
                break;
            }
            temp(arr,s,e);
            s++;
            e--;
        }
        bw.write(new String(arr));
        bw.flush();
        bw.close();
    }
    static void temp(char[] arr, int a,int b){
            char tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
    }
    static boolean isap(char ch){
        if ((ch >= 'a' && ch <= 'z')|| (ch >= 'A' && ch <= 'Z')) {
            return true;
        }
        return false;
    }

}
