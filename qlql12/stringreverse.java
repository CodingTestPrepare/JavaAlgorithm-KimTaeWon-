import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main codingTest = new Main();
        codingTest.start();
    }
    public void start() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        String[] sb = new String[i];
        int count = 0;
        char tt;

        while (3 <= i && i <= 20 && i > count){
            char[] chars = sc.next().toCharArray();
            int x = 0;
            int y = chars.length;

            for (int j = 0; j < chars.length / 2; j++) {
                if(x <= j){
                    y--;
                    tt = chars[j];
                    chars[j] = chars[y];
                    chars[y] = tt;
                }
            }
            sb[count] = String.valueOf(chars);
            count++;
        }

        for (int j = 0; j < sb.length; j++) {
            System.out.println(sb[j]);
        }
    }
}
