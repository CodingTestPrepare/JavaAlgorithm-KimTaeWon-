import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
 * 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * 회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다
 */
public class Solution {
    static int c = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Meeting[] arr = new Meeting[n];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            arr[i] = new Meeting(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
        }
        solution(arr, n);
    }

    static void solution(Meeting[] arr, int n) {
        Arrays.sort(arr);
        int c=0;
        Meeting end = new Meeting(-1, -1);
        for (int i = 0; i < arr.length; i++) {
            if(end.e <= arr[i].s){
                c++;
                end = arr[i];
            }
        }
        System.out.println(c);
    }
}

class Meeting implements Comparable<Meeting> {
    int s, e;

    @Override
    public String toString() {
        return "Meeting{" +
                "s=" + s +
                ", e=" + e +
                '}';
    }

    public Meeting(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.e == o.e) {
            return this.s - o.s;
        }
        return this.e - o.e;
    }
}
