import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main codingTest = new Main();
        codingTest.start();
    }
    public void start() {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.next().toLowerCase(Locale.ROOT).toCharArray();
        int y = chars.length-1;
        int i = 0;
        boolean flag = true;

        while (i < y) {
            char c1 = chars[i];
            char c2 = chars[y];

            if(c1 == c2) {
                i++;
                y--;
                flag = true;
            } else {
                flag = false;
                break;
            }
        }

        if(flag) {
            System.out.println("YES");
        } else  System.out.println("NO");
    }
}
