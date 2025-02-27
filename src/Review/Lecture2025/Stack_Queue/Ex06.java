package Review.Lecture2025.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 공주 구하기
// 8 3
// 답 봐
public class Ex06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int cnt = 0;
        while (q.size() > 1) {
            cnt++;
            int tmp = q.poll();
            if (cnt == k) {
                cnt = 0;
            } else {
                q.offer(tmp);
            }
        }
        System.out.println(q.poll());

    }
}
