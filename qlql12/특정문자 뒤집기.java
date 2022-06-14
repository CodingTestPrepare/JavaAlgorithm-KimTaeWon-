import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main codingTest = new Main();
        codingTest.start();
    }
    public void start() {
        Scanner sc = new Scanner(System.in);
        char tt;
        char[] chars = sc.next().toCharArray();
        int y = chars.length-1;
        int i = 0;

        while (i < y) {
            char c1 = chars[i];
            char c2 = chars[y];

            //앞부분이 특수문자인지 확인
            if(!('a' <= c1 && c1 <= 'z' || 'A' <= c1 && c1 <= 'Z')) {
                i++;
                //뒷부분이 특수문자인지 확인
            } else if (!('a' <= c2 && c2 <= 'z' || 'A' <= c2 && c2 <= 'Z')) {
                y--;
            } else {
                tt = chars[i];
                chars[i] = chars[y];
                chars[y] = tt;
                i++;
                y--;
            }
        }
        for (int j = 0; j < chars.length; j++) {
            System.out.print(chars[j]);
        }
    }
}
