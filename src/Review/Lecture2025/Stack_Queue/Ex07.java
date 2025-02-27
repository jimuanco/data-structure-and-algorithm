package Review.Lecture2025.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 교육과정 설계
/*
CBA
CBDAGE
 */
// 답 봐
public class Ex07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String priority = br.readLine();
        String plan = br.readLine();

        Queue<Character> q = new LinkedList<>();
        for (char c : plan.toCharArray()) {
            q.offer(c);
        }

        int cnt = 0;
        for (char c : priority.toCharArray()) {
            while (!q.isEmpty()) {
                char tmp = q.poll();
                if (tmp == c) {
                    cnt++;
                    break;
                }
            }
        }
        String ans = " ";
        if (cnt == priority.length()) {
            ans = "YES";
        } else {
            ans = "NO";
        }
        System.out.println(ans);



    }
}
