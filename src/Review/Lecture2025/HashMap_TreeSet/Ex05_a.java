package Review.Lecture2025.HashMap_TreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// K번째 큰 수
/*
10 3
13 15 34 23 45 65 33 11 26 42
 */
public class Ex05_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = -1;
        Set<Integer> ts = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    ts.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (Integer i : ts) {
            cnt++;
            if (cnt == k) {
                ans = i;
            }
        }
        System.out.println(ans);
    }
}
