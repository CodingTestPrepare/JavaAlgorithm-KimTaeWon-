import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main codingTest = new Main();
        codingTest.start();
    }
    public void start() {
        Scanner sc = new Scanner(System.in);
        String line = sc.next() + " ";
        int count = 1;
        String outPut = "";

        for (int i = 0; i < line.length()-1; i++) {
            if(line.charAt(i) == line.charAt(i+1)) {
                count++;
            } else {
                outPut = outPut + line.charAt(i);
                if(count > 1){
                    outPut = outPut + count;
                }
                count = 1;
            }
        }
        System.out.println(outPut);
    }
}