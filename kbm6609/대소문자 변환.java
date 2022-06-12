/**
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 */
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int tolow =  'a'-'A';
        int toup = 'A' -'a';
        for(char ch : str.toCharArray()){
            if(ch>= 'A' && ch <='Z'){
                bw.write((ch+tolow));
            }else{
                bw.write((ch + toup));
            }
        }
        bw.flush();
        bw.close();
    }
}
