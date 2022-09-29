import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
 * 각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
 * 단 강연의 특성상 하루에 하나의 기업에서만 강연을 할 수 있다.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
        solution2(str, n);
    }

    /**
     * Version1
     * 수입 순으로 내림차순 정렬을 하고
     * 가장 높은 수입 은 무조건 실행 해야하므로 가능한 가장 마지막날 수행하도록한다.
     * 이때 행사가 잡힌날짜를 표시하기 위해 day 배열을 이용해서 체크한다.
     * 행사를 해야하는 날짜에 이미 행사가 존재하면 전날에 수행하도록한다.( 가장 높은 수입이므로 무조건 수행해야함)
     * 모든 날짜가 꽉차면 -> if(count == n)  || 모든 행사 후보들을 순회 하면  로직을 중단한다.
     * <p>
     * 최악의 경우 1+2+3+...+n 번 수행 즉 n(n+1)/2 의 수행시간을 갖는다 (O(n²))
     */
    static void solution1(String[] str, int n) {
        ArrayList<IncomeVersion1> arr = new ArrayList<>();
        boolean[] day = new boolean[n];
        int count = 0;
        int sumIncome = 0;
        for (int i = 0; i < str.length; i++) {

            String[] tmp = str[i].split(" ");
            arr.add(new IncomeVersion1(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])));
        }
        arr.sort(IncomeVersion1::compareTo);
        for (int i = 0; i < arr.size(); i++) {
            IncomeVersion1 income = arr.get(i);
            for (int j = income.time - 1; j >= 0; j--) {
                if (!day[j]) {
                    day[j] = true;
                    sumIncome += income.income;
                    count++;
                    break;
                }
            }
            if (count == n) {
                break;
            }
        }
        System.out.println(sumIncome);
    }

    /**
     * Version2(best)
     * 행사를 할수있는 가장 마지막 날부터 그날 해야할 행사를 정하는 방식으로 수행한다.
     * day 순으로 내림차순 정렬후 pq 에 그날에 해당하는 모든 값(income 값만)을 넣는다.
     * 그 후 poll() 을 통해 가장 큰값을 뽑아서 그날 수행할 행사를 정하고 pq 에 남아있는 행사후보는 전날 할 행사 후보들과 합쳐져서
     * 전날 행사 후보로 쓰인다.
     * <p>
     * O(nlog(n)) 의 수행시간을 갖는다.
     */
    static void solution2(String[] str, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<IncomeVersion2> arr = new ArrayList<>();
        int sumIncome = 0;
        for (int i = 0; i < str.length; i++) {
            String[] tmp = str[i].split(" ");
            arr.add(new IncomeVersion2(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])));
        }
        arr.sort(IncomeVersion2::compareTo);
        int lastDay = arr.get(0).time;
        for (int i = 0; i < arr.size(); i++) {
            while (lastDay > arr.get(i).time && !pq.isEmpty()) {
                Integer poll = pq.poll();
                sumIncome += poll;
                lastDay--;
            }
            if (lastDay != arr.get(i).time) {
                lastDay = arr.get(i).time;
            }
            pq.add(arr.get(i).income);
        }
        while (lastDay >=1 && !pq.isEmpty()) {
            Integer poll = pq.poll();
            sumIncome += poll;
            lastDay--;
        }
        System.out.println(sumIncome);
    }

}

class IncomeVersion1 implements Comparable<IncomeVersion1> {
    int income;
    int time;

    public IncomeVersion1(int income, int time) {
        this.income = income;
        this.time = time;
    }

    @Override
    public int compareTo(IncomeVersion1 o) {
        return o.income - this.income;
    }
}

class IncomeVersion2 implements Comparable<IncomeVersion2> {
    int income;
    int time;

    public IncomeVersion2(int income, int time) {
        this.income = income;
        this.time = time;
    }

    @Override
    public int compareTo(IncomeVersion2 o) {
        return o.time - this.time;
    }
}