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
        int output = 0;

        for (char x : chars) {
            if(x >= 48 && x <= 57) {
                output  = output * 10 + (x-48);
            }
        }
        System.out.println(output);
    }
}