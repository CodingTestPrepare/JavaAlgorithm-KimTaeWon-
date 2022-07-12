package test;






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
        int n =sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int k =sc.nextInt();
        int[] actions = new int[k];
        for (int i = 0; i < k; i++) {
            actions[i] =sc.nextInt();
        }
//        startTime = System.currentTimeMillis();
        solution(n,arr,k,actions);
//        finishTime = System.currentTimeMillis();
//        elapsedTime = finishTime - startTime;
//        System.out.println("실행 시간(ms) : " + elapsedTime);
    }

    static void solution(int n,int[][] arr, int k ,int[] actions) {
        Stack<Integer> st = new Stack<>();
        int count =0;
        int[] arrPoint = new int[n];
        for (int i = 0; i < k; i++) {
            int tmp =actions[i]-1;
            while (arrPoint[tmp] < n && arr[arrPoint[tmp]][tmp] == 0) {
                arrPoint[tmp]++;
            }
            if (arrPoint[tmp] < n) {
                if (st.isEmpty() || st.peek() != arr[arrPoint[tmp]][tmp]) {
                    st.push(arr[arrPoint[tmp]][tmp]);
                } else {
                    st.pop();
                    count+=2;
                }
                arrPoint[tmp]++;
            }
        }
        System.out.println(count);
    }
}