import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main codingTest = new Main();
        codingTest.start();
    }
    public void start() {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if('a' <= chars[i] && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 32);
            } else if('A' <= chars[i] && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        System.out.println(chars);
    }
}
