/**
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 * 문자열의 길이는 100을 넘지 않는다.
 */

import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        solution(s[0],s[1].charAt(0));
    }
    static void solution(String str,char ch) {
        int count = -1;
        char[] arr = str.toCharArray();
        int[] result =new int[arr.length];
        Arrays.fill(result, Integer.MAX_VALUE);

        for(int i=0;i<arr.length;i++){
            if(arr[i]== ch) {
                for (int j =1;i-j >= 0; j++) {
                    if(result[i - j] < j) break;
                    result[i - j] = j;
                }
                count = 0;
            }
            if(count >= 0){
                if(result[i] > count) result[i] = count++;
            }
        }
        for (int i : result) {
            System.out.print(i+" ");
        }
    }

}