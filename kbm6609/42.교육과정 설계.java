package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String order =sc.next();
        String str =sc.next();
//        startTime = System.currentTimeMillis();
        solution(order,str);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }

    static void solution(String order,String str) {
        Queue<Character> st = new LinkedList<>();
        String result ="YES";
        for (char ch : order.toCharArray()) {
            st.add(ch);
        }
        for (char ch : str.toCharArray()) {
            if(st.isEmpty()) break;
            if (st.peek() == ch){
                st.poll();
            }
        }
        if(!st.isEmpty())  result ="NO";
        System.out.println(result);
    }
}
