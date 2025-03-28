package Review.Lecture2025.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 결혼식
// Baekjoon Ex11000(강의실 배정)과 같은 유형
/*
5
14 18
12 15
15 20
20 30
5 14
 */
public class Ex03_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.add(new Time(s,'s'));
            arr.add(new Time(e,'e'));
        }
        arr.sort((o1, o2) -> o1.time == o2.time ? o1.state - o2.state : o1.time - o2.time);
        int cnt = 0, answer = Integer.MIN_VALUE;
        for (Time t : arr) {
            if (t.state == 's') cnt++;
            else if (t.state == 'e') cnt--;
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
    private static class Time {
        int time;
        char state;
        public Time(int time, char state) {
            this.time = time;
            this.state = state;
        }
    }
}
