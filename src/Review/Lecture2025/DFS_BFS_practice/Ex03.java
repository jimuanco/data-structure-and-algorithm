package Review.Lecture2025.DFS_BFS_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최대점수 구하기(DFS) -> N이 20까지라 DFS로 풀 수 있음(DP Ex06 참조)
/*
5 20
10 5
25 12
15 8
6 3
7 4
 */
public class Ex03 {
    static int n, m, answer;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0, 0);
        System.out.println(answer);
    }

    private static void DFS(int L, int sumS, int sumT) {
        if (sumT > m) return;
        if (L == n) {
            answer = Math.max(sumS, answer);
        } else {
            DFS(L + 1, sumS + arr[L][0], sumT + arr[L][1]);
            DFS(L + 1, sumS, sumT);
        }
    }
}