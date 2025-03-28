package Review.Lecture2025.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 회의실 배정(o(n)) -> 끝나는 순으로 오름차순 (같다면 시작순으로 오름차순)
/*
5
1 4
2 3
3 5
4 6
5 7
 */
/*
3
3 3
1 3
2 3
 */
public class Ex02_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Time> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Time(x, y));
        }
        list.sort((o1, o2) ->
                o1.e == o2.e ? Integer.compare(o1.s, o2.s) : Integer.compare(o1.e, o2.e));
        int et = 0, cnt = 0;
        for (Time t : list) {
            if (t.s >= et) {
                cnt++;
                et = t.e;
            }
        }
        System.out.println(cnt);
    }

    private static class Time {
        int s, e;
        Time (int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
