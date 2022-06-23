/**
 *  첫줄에 자연수 N 이 입력된다.
 *  두번째 줄에 N 개의 자연수가 입력된다.
 *  가장 높은 숫자를 가진 순서에 1 을 주고 아래로 갈수록 2,3,4,5... 이렇게 부여를 할것이다.
 *  이때 중복된 숫자들은 같은 숫자를 부여하고 그 다음 숫자에전체 몇번째인지를 부여한다.
 *  즉 , 100 ,100 ,90 -> 1 ,1 ,3
 */

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int[] arr =new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }
        solution(N,arr);
    }
    static void solution(int N, int[] arr) {
        HashMap<Integer,Integer> hs =new HashMap<>();
        Integer[] st = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).toArray(Integer[]::new);
        int count =1;
        for (int i : st) {
            if(!hs.containsKey(i)){
                hs.put(i,count);
            }
            count++;
        }
        for (int i : arr) {
            System.out.print(hs.get(i)+" ");
        }
    }
}