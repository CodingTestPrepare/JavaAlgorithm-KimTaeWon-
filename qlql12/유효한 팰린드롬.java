import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main codingTest = new Main();
        codingTest.start();
    }
    public void start() {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toLowerCase(Locale.ROOT).toCharArray();
        boolean flag = true;

        int x = 0;
        int y = chars.length-1;

        while (x < y) {
            if(!('a' <= chars[x] && chars[x] <= 'z')) {
                x++;
            } else if(!('a' <= chars[y] && chars[y] <= 'z')){
                y--;
            }
            else {
                if(chars[x] == chars[y]) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
                x++;
                y--;
            }
        }

        if(flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}