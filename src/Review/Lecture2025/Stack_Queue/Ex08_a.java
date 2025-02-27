package Review.Lecture2025.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 응급실
/*
5 2
60 50 70 80 90
 */
/*
6 3
70 60 90 60 60 60
 */
public class Ex08_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0, cnt = 0;
        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(new Person(i, arr[i]));
        }
        while (!q.isEmpty()) {
            Person tmp = q.poll();
            for (Person x : q) {
                if (x.priority > tmp.priority) {
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                cnt++;
                if (tmp.id == m) {
                   ans = cnt;
                   break;
                }
            }
        }
        System.out.println(ans);
    }

    private static class Person {
        int id;
        int priority;
        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
}
