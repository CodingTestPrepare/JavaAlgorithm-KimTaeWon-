package test;

/**
 * 캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가
 * 필요할 바로 사용해서 처리속도를 높이는 장치이다. 워낙 비싸고 용량이 작아 효율적으로 사용해야 한다.
 * 철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.
 * LRU 알고리즘은 Least Recently Used 의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
 * 캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.
 *
 * 캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
 * 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int[] arr =new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] =sc.nextInt();
        }
//        startTime = System.currentTimeMillis();
        solution(n,k,arr);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }

    static void solution(int n,int k, int[] arr) {
        HashMap<Integer,Integer> hs =new HashMap<>();
        PriorityQueue<memory> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            hs.put(arr[i], i);
        }
        for (int i : hs.keySet()) {
            pq.add(new memory(hs.get(i), i));
        }
        while (!pq.isEmpty() && n > 0) {
            n--;
            System.out.print(pq.poll().num + " ");
        }
    }
}

class memory implements Comparable<memory> {
    int order;
    int num;
    public memory(int order, int num) {
        this.order = order;
        this.num = num;
    }

    @Override
    public int compareTo(memory o) {
        return o.order-this.order ;
    }
}

