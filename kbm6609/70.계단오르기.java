import java.io.*;

/**
 *  계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는
 * 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.
 * 그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?
 * n<=35
 */
class Main {
    static long[] fac = new long[12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution1(n);
    }

    /**
     * Version1
     * 중복 조합 공식을 활용한 방식
     * <p>
     * 중복 조합공식을 그대로 사용하면 long 최대 범위를 초과 하는 문제가 발생하여
     * 공식을 약간 수정하였다.
     */
    static void solution1(int n) {
        long result = 0;
        fac[0] = 1;
        fac[1] = 1;
        for (int i = 2; i < 12; i++) {
            fac[i] = fac[i - 1] * i;
        }
//        1   2   3   4   5   6   8   7   9   10  11  12  13  14  15  16 ;
//        31  29  27  25  23  21  19  17  15  13  11  9   7   5   3   1
        int[] arr = new int[2];
        arr[0] = n / 2;
        arr[1] = n % 2;
        int c = arr[0] + arr[1];
        while (arr[0] >= 0) {
            long i = calNum(arr, c);
//            System.out.println(i);
            result += i;
            arr[0]--;
            arr[1] += 2;
            c++;
        }
        System.out.println(result);

    }


    static long calNum(int[] arr, int c) {
        long result = 1;
        int minIndex = 0, maxIndex = 1;
        if (arr[0] > arr[1]) {
            minIndex = 1;
            maxIndex = 0;
        }
        for (int i = c; i > arr[maxIndex]; i--) {
            result *= i;
        }
        return result / fac[arr[minIndex]];
    }

    /**
     * Version2 (best)
     * dp 를 사용는 방식
     */
    static void solution2(int n) {
        int result = 0;
        int[] dy = new int[36];
        dy[1] = 1;
        dy[2] = 2;
        System.out.println(dyMethod(dy,n));
    }

    static int dyMethod(int[] dy, int target) {
        if (dy[target] != 0) {
            return dy[target];
        }
        return dy[target] = dyMethod(dy, target - 1) + dyMethod(dy, target - 2);
    }
}
//// 카카오 4번
//class Main {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long :: parseLong).toArray();
//        Arrays.sort(input);
//        long[] maxinput=Arrays.copyOf(input,input.length);
//        long min = minCount(input);
//        long max = maxCount(maxinput);
//        System.out.println(min);
//        System.out.println(max);
//    }
//    static boolean checkCol(long[] input){
//        if(input[0]+1==input[1] &&input[1]+1 ==input[2]){
//            return true;
//        }
//        return false;
//    }
//    static long minCount(long[] input){
//        int s,l;
//        if(input[1] - input[0] > input[2] - input[1]){
//            s=2;
//            l=0;
//        }else{
//            s=0;
//            l=2;
//        }
//        if(checkCol(input)) return 0;
//        if (Math.abs(input[s] - input[1]) == 2 || Math.abs(input[l] - input[1]) == 2) {
//            return 1;
//        }
//        return 2;
//    }
//    static long maxCount(long[] input){
//        int l;
//        if(input[1] - input[0] > input[2] - input[1]){
//            l=0;
//        }else{
//            l=2;
//        }
//        return Math.abs(input[l] -input[1]) -1;
//    }
//}

/**
 * 1번 문제제
 * static public int solution(String s) {
 * int answer = -1;
 * int start=0, end=0;
 * int count = 0;
 * char[] arr =s.toCharArray();
 * for(;end < arr.length;end++){
 * if(arr[start] == arr[end]){
 * count++;
 * }else{
 * start = end;
 * count = 1;
 * }
 * if (count == 3) {
 * answer = Math.max(answer,Integer.parseInt(s.substring(start,end+1)));
 * start = end + 1;
 * count = 0;
 * }
 * }
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 * 2번 문제
 * static public int solution(int[] levels) {
 * int answer = -1;
 * int len =levels.length;
 * if(len>=4) {
 * Arrays.sort(levels);
 * answer = levels[len-len/ 4];
 * }
 * return answer;
 * }
 * 3번 문제
 * static public int solution(int k, int[][] dungeons) {
 * int answer = 0;
 * check = new boolean[dungeons.length];
 * run(k,dungeons,0);
 * answer =count;
 * return answer;
 * }
 * <p>
 * static void run(int k, int[][] dungeons, int c) {
 * for (int i = 0; i < check.length; i++) {
 * if (!check[i] && k >= dungeons[i][0]) {
 * check[i] = true;
 * run(k - dungeons[i][1], dungeons, c + 1);
 * check[i] = false;
 * }
 * }
 * count = Math.max(c,count);
 * }
 * }
 * <p>
 * 5번 문제
 * static public int solution(int[] tasks) {
 * int answer = 0;
 * HashMap<Integer,Integer> hs =new HashMap<>();
 * <p>
 * for(int i :tasks){
 * hs.put(i,hs.getOrDefault(i,0)+1);
 * }
 * for (int i : hs.keySet()) {
 * int t =hs.get(i);
 * if (t < 2) {
 * answer = -1;
 * break;
 * } else {
 * answer += t/3;
 * answer += t%3 ==0 ? 0 : 1;
 * }
 * }
 * // 0 1 2
 * return answer;
 * }
 */
/** 2번 문제
 *   static public int solution(int[] levels) {
 *         int answer = -1;
 *         int len =levels.length;
 *         if(len>=4) {
 *             Arrays.sort(levels);
 *             answer = levels[len-len/ 4];
 *         }
 *         return answer;
 *     }
 */
/** 3번 문제
 *  static public int solution(int k, int[][] dungeons) {
 *         int answer = 0;
 *         check = new boolean[dungeons.length];
 *         run(k,dungeons,0);
 *         answer =count;
 *         return answer;
 *     }
 *
 *     static void run(int k, int[][] dungeons, int c) {
 *         for (int i = 0; i < check.length; i++) {
 *             if (!check[i] && k >= dungeons[i][0]) {
 *                 check[i] = true;
 *                 run(k - dungeons[i][1], dungeons, c + 1);
 *                 check[i] = false;
 *             }
 *         }
 *         count = Math.max(c,count);
 *     }
 * }
 *
 */
/** 5번 문제
 *  static public int solution(int[] tasks) {
 *         int answer = 0;
 *         HashMap<Integer,Integer> hs =new HashMap<>();
 *
 *         for(int i :tasks){
 *             hs.put(i,hs.getOrDefault(i,0)+1);
 *         }
 *         for (int i : hs.keySet()) {
 *             int t =hs.get(i);
 *             if (t < 2) {
 *                 answer = -1;
 *                 break;
 *             } else {
 *                 answer += t/3;
 *                 answer += t%3 ==0 ? 0 : 1;
 *             }
 *         }
 *         // 0 1 2
 *         return answer;
 *     }
 */
