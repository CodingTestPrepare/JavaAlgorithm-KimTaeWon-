/**
 * N 명의 사람들을 일렬로 세웟을때
 * 맨 앞에잇는 사람이 볼수 있는 사람의 최대 인원수
 * 단. 앞에잇는 사람보다 키가 커야 보인다.
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int[] arr =new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(solution(arr, N));
    }
    static int solution(int[] arr, int N) {
        int count=1;
        int max= arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                count++;
                max =arr[i];
            }
        }
        return count;
    }
}