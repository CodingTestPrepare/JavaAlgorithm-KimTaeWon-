package test;

/**
 * 설명
 * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 *
 * 입력
 * 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
 *
 * 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
 */




import java.util.Scanner;
import java.util.Stack;
class Main {
    public static void main(String[] args) {


//        long beforeUsedHeap2 = getRuntime().totalMemory()-getRuntime().freeMemory();

/*

        long afterUsedHeap2 = getRuntime().totalMemory()-getRuntime().freeMemory();
        System.out.printf("beforeUsedHeap \t : %6.2f MB\n",(double)beforeUsedHeap2/(1024*1024));
        System.out.printf("afterUsedHeap \t  : %6.2f MB\n",(double)afterUsedHeap2/(1024*1024));
        System.out.printf("totalUsed  \t     : %6.2f MB\n", (double)(afterUsedHeap2-beforeUsedHeap2 )/(1024*1024));
*/
        Scanner sc = new Scanner(System.in);
       String str =sc.next();
//        startTime = System.currentTimeMillis();
        solution(str);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }

    static void solution(String str) {
        Stack<Integer> st =new Stack<>();
        for (char ch : str.toCharArray()) {
            if(Character.isDigit(ch)){
                st.add(ch-'0');
            }else{
                st.push(opChar(st.pop(),st.pop(),ch));
            }
        }
        System.out.println(st.pop());
    }
    static int opChar(int c2,int c1,char op){
        switch (op){
            case'+':
                return c1+c2;
            case'-':
                return c1-c2;
            case'*':
                return c1*c2;
            default:
                return c1/c2;
        }
    }
}