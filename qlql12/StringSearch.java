import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main codingTest = new Main();
        codingTest.start();
    }
    public void start() {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toLowerCase().toCharArray();
        char c = sc.next().charAt(0);
        char lowerCase = Character.toLowerCase(c);
        int count = 0;

        for (int i = 0; i < chars.length; i++) {
            if(lowerCase == chars[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
