import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main codingTest = new Main();
        codingTest.start();
    }
    public void start() {
        Scanner sc = new Scanner(System.in);
        String[] chars = sc.nextLine().trim().split(" ");
        String input = "";

        for (int i = 0; i < chars.length; i++) {
            if(input.length() <= chars[i].length()) {
                input = chars[i];
            }
        }
        System.out.println(input);
    }
}
