import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main codingTest = new Main();
        codingTest.start();
    }
    public void start() {
        Scanner sc = new Scanner(System.in);
        char[] line = sc.next().toCharArray();
        String s = sc.next();
        int[] arr = new int[line.length];
        int p = 1000;
        int count  = -1;

        for (int j = 0; j < line.length; j++) {
            //지정한 문자열 c와 같은지 확인
            if(String.valueOf(line[j]).equals(s)) {
                p = 0;
                arr[j] = p;
                count = j;
            }else {
                if (count == -1) {
                    arr[j] = p;
                    continue;
                }
                if(j - count <= 0) {
                    arr[j] = p;
                } else{
                    arr[j] = j - count;
                }
            }
        }

        for (int j = line.length-1; j >= 0; j--) {
            if(arr[j] == 0){
                count = j;
            } else {
                if(count - j < arr[j] && count - j > 0) { //count - j
                    arr[j] = count - j;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
