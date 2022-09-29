import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 피로연에 참석하는 친구들 N명의 참석하는 시간정보를 현수는 친구들에게 미리 요구했습니다.
 * 각 친구들은 자신이 몇 시에 도착해서 몇 시에 떠날 것인지 현수에게 알려주었습니다.
 * 현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을 수용할 수 있는 장소를 빌리려고 합니다. 여러분이 현수를 도와주세요.
 * 만약 한 친구가 오는 시간 13, 가는시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는 것이고 15시 정각에는 존재하지 않는다고 가정합니다.
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
//        solution1(str, n);
        solution2(str, n);
    }

    /**
     * Version1
     * 각 사람마다 시간정보를 객체에 담아서
     * 시간 시간 기준으로 오름차순 정렬(같으면 끝나느시간으로 오름차순 정렬)
     * 을 해서 먼져 시작한 사람순으로 로직을 수행
     * 이때 들어오는 사람들 의 끝나는 시간을 기준으로 nowTime 이라는 객체에 끝나는 시간을 저장해두고 (오름차순정렬)
     * 사람이 들어올때 해당 시간에 이미 나간사람들을 nowTime 리스트에서 제거하는 식으로 현재 존재하는 사람들을 체크
     */
    static void solution1(String[] str, int n) {
        PriorityQueue<NowMeeting> pq = new PriorityQueue<>();
        Meeting[] arr = new Meeting[n];
        for (int i = 0; i < n; i++) {
            String[] tmp = str[i].split(" ");
            arr[i] = new Meeting(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
        }
        int result = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty()) {
                if (pq.peek().e <= arr[i].s) {
                    pq.poll();
                } else {
                    break;
                }
            }
            pq.add(new NowMeeting(arr[i].e));
            result = Math.max(pq.size(), result);
        }
        System.out.println(result);
    }

    /**
     * Version2 (best)
     * 들어오는 시간을 s , 끝나는 시간을 e 로 표시하고
     * 객체에 시간,'s' or 'e' 를 저장해서 시간으로 오름차순 정렬한다. (시간이 같으면 e 가 우선)
     * 이 리스트를 순회 하면서 s 등장서 count++ 해주고 e 등장시 -- 을 해줌으로 값을 찾는다.
     */
    static void solution2(String[] str, int n) {
        ArrayList<TimeVersion2> arr = new ArrayList<>();
        int count = 0;
        int result=0;
        for (int i = 0; i < n; i++) {
            String[] tmp = str[i].split(" ");
            arr.add(new TimeVersion2(Integer.parseInt(tmp[0]), 's'));
            arr.add(new TimeVersion2(Integer.parseInt(tmp[1]), 'e'));
        }
        arr.sort(TimeVersion2::compareTo);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).type == 's') {
                count++;
            }else{
                count--;
            }
            result = Math.max(count,result);
        }

        System.out.println(result);
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
        if (this.s == o.s) {
            return this.e - o.e;
        }
        return this.s - o.s;
    }
}

class NowMeeting implements Comparable<NowMeeting> {
    int e;


    public NowMeeting(int e) {
        this.e = e;
    }

    @Override
    public int compareTo(NowMeeting o) {
        return this.e - o.e;
    }
}

class TimeVersion2 implements Comparable<TimeVersion2> {
    int time;
    char type;

    public TimeVersion2(int time, char type) {
        this.time = time;
        this.type = type;
    }

    @Override
    public int compareTo(TimeVersion2 o) {
        if (this.time == o.time) {
            return this.type - o.type;
        }
        return this.time - o.time;
    }
}
