import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main codingTest = new Main();
        codingTest.start();
    }
    public void start() {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            if(input.indexOf(input.charAt(i)) == i) {
                output += input.charAt(i);
            }
        }
        System.out.println(output);
    }
}
