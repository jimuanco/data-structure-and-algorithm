package Review.Lecture2025.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 점수계산
/*
10
1 0 1 1 1 0 0 1 1 0
 */
public class Ex07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                ans += cnt;
                cnt++;
            } else {
                cnt = 1;
            }
        }
        System.out.println(ans);
    }
}
