import java.io.*;
/**
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
 * 대소문자를 구분하지 않습니다. 문자열의 길이는 100을 넘지않습니다.
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();
        char ch = br.readLine().toLowerCase().charAt(0);
        int num=0;
        for (char tmp : str.toCharArray()) {
            if(tmp ==ch ) num++;
        }
        System.out.println(num);
    }
}
