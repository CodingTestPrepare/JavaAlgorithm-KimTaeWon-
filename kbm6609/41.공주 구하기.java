package test;
/**
 *  1번부터 N번까지 차례로 번호를 매긴다.
 * 그리고 1번 ~ N번  순서대로 시계 방향으로 돌아가며 동그랗게 앉게 한다.
 *  K 가 입력으로 주어진다 .( 1<=k)
 *  1번부터 시작하여 k번쨰 순서에 잇는 사람을 제외한다.
 *  제외된 사람의 위치로 부터 k번째 잇는 사람을 제외한다.( k번째를 셀때 제외된사람은 카운트 하지않음)
 *  이렇게 마지막 1사람만 남을떄 까지 반복하엿을때 살아 남은 사람의 번호를 출력 하여라
 *
 *  첫 줄에 자연수 N(5<=N<=1,000)과 K(2<=K<=9)가 주어진다.
 *  ex)
 *  8 3   --> 7
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
        int n= sc.nextInt();
        int k =sc.nextInt();
//        startTime = System.currentTimeMillis();
        solution(n,k);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }

    static void solution(int n,int k) {
        List<Integer> list =new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }
        int index=0;
        while(list.size()>1){
            index = (index+k-1)%list.size();
            list.remove(index);
        }
        System.out.println(list.get(0));
    }
}