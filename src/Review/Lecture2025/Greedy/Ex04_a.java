package Review.Lecture2025.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최대수입스케쥴(PriorityQueue)
// Baekjoon Ex1202(보석 도둑)과 비슷한 유형
/*
6
50 2
20 1
40 2
60 3
30 3
30 1
 */
public class Ex04_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Lecture> arr = new ArrayList<>();
        StringTokenizer st;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d =  Integer.parseInt(st.nextToken());
            arr.add(new Lecture(m, d));
            if (d > max) {
                max = d;
            }
        }
        arr.sort((o1, o2) -> o2.date -  o1.date);
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0, j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (arr.get(j).date < i) {
                    break;
                }
                pQ.offer(arr.get(j).money);
            }
            if (!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }
        System.out.println(answer);
    }

    private static class Lecture {
        int money, date;
        Lecture(int money, int date) {
            this.money = money;
            this.date = date;
        }
    }
}
