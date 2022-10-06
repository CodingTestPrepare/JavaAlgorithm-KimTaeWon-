import java.io.*;
import java.util.Arrays;

/**
 * 백준 문제
 * 1759(소수 구하기)
 * https://www.acmicpc.net/problem/1759
 */
public class Main {
    static int l, c;
    static char[] arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        l = Integer.parseInt(str[0]);
        c = Integer.parseInt(str[1]);
        arr = br.readLine().replaceAll(" ","").toCharArray();
        check =new boolean[c];
        solution1();
    }

    static void solution1() {
        Arrays.sort(arr);
        dfs(0,0,0,0);
    }

    static void dfs(int index, int count, int a, int b) {
        if (count == l) {
            if(a >= 1 && b>= 2) {
                for (int i = 0; i < c; i++) {
                    if (check[i]) {
                        System.out.print(arr[i]);
                    }
                }
                System.out.println();
            }
            return;
        }
        if(index >= c){
            return;
        }
        int na , nb;
        for (int i = index; i < c; i++) {
            check[i] = true;
            na = a;
            nb = b;
            if(isMoum(arr[i])){
                na++;
            }else{
                nb++;
            }
            dfs(i+1,count+1,na,nb);
            check[i] =false;
        }
    }
    static boolean isMoum(char ch){
        switch (ch) {
            case 'a': case'e': case'o': case'u': case'i':
                return true;
            default:
                return false;
        }
    }

}

