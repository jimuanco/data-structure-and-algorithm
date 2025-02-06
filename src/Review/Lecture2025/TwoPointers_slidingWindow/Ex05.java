package Review.Lecture2025.TwoPointers_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 연속된 자연수의 합
// 15
// 답이 더 깔끔
public class Ex05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int ans = 0, sum = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == n) {
                ans++;
            }
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) {
                    ans++;
                }
            }
        }
        ans--;
        System.out.println(ans);
    }
}
