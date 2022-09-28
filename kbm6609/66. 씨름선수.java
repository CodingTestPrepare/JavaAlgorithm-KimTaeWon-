import java.io.*;
import java.util.ArrayList;

/**
 * “A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가
 * 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
 * N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.
 */
public class Solution {
    static int c = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Athlete[] arr = new Athlete[n];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            arr[i] = new Athlete(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
        }
        solution(arr, n);
    }

    static void solution(Athlete[] arr, int n) {
        ArrayList<Athlete> choice = new ArrayList<>();
        l : for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < choice.size(); j++) {
                Athlete choiceAthlete = choice.get(j);
                if (choiceAthlete.h < arr[i].h && choiceAthlete.m < arr[i].m) {
                    choice.remove(choiceAthlete);
                    j--;
                }
                if (choiceAthlete.h > arr[i].h && choiceAthlete.m > arr[i].m) {
                    continue l;
                }
            }
            choice.add(arr[i]);
        }
        System.out.println(choice.size());
    }
}

class Athlete {
    int h, m;

    public Athlete(int h, int m) {
        this.h = h;
        this.m = m;
    }
}
