import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main codingTest = new Main();
        codingTest.start();
    }
    public void start() {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        char s = sc.next().charAt(0);
        int[] arr = new int[line.length()];
        int p = 1000;
        int count  = -1;

        for (int j = 0; j < line.length(); j++) {
            //지정한 문자열 c와 같은지 확인
            if(line.charAt(j) == s) {
                p = 0;
                arr[j] = p;
            } else {
                p++;
                arr[j] = p;
            }
        }
        p = 1000;
        for (int j = line.length()-1; j >= 0; j--) {
            //지정한 문자열 c와 같은지 확인
            if(line.charAt(j) == s) {
                p = 0;
            } else {
                p++;
                arr[j] = Math.min(arr[j], p);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

//for (int i = 0; i < chars.length; i++) {
//        if('A' <= chars[i] && chars[i] <= 'Z') {
//        arr[Integer.parseInt(String.valueOf(chars[i])) - 97] ++;
//
//    int p = 1000;
//        for (int j = line.length()-1; j >= 0; j--) {
//                if(arr[j] == 0){
//                count = j;
//                } else {
//                if(count - j < arr[j] && count - j > 0) { //count - j
//        arr[j] = count - j;
//        }
//        }
//        }
//        }