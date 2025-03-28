package Review.Lecture2025.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 동전교환(냅색 알고리즘) -> 동전 종류 개수가 50까지라 DFS로 안됨(시간초과, DFS_BFS_practice Ex05 참조)
// Baekjoon Ex2839(설탕 배달)과 비슷한 유형
/*
3
1 2 5
15
 */
public class Ex05_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coin = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
            }
        }
        System.out.println(dy[m]);

    }
}
