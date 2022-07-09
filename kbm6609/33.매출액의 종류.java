package test;

import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n= sc.nextInt();
        k = sc.nextInt();
        int[] arr= new int[n];

        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }
//        startTime = System.currentTimeMillis();
        solution(n,k,arr);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }

    static void solution(int n, int k, int[] arr) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        StringBuilder sb =new StringBuilder();
        int count =0;
        for(int i=0; i<n;i++){
            if(count<k){
                count++;
                hs.put(arr[i],hs.getOrDefault(arr[i],0)+1);
            }else{
                sb.append(hs.size()+" ");
                hs.put(arr[i], hs.getOrDefault(arr[i], 0) + 1);
                hs.put(arr[i-k],hs.get(arr[i-k])-1);
                if (hs.get(arr[i - k]) == 0) {
                    hs.remove(arr[i - k]);
                }
            }
        }
        sb.append(hs.size() + " ");
        System.out.println(sb);
    }
}
