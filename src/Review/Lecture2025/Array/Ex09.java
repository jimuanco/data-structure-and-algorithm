package Review.Lecture2025.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 격자판 최대합
/*
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19
 */
public class Ex09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sumD1 = 0, sumD2 = 0, max = 0;
        for (int i = 0; i < n; i++) {
            int sumX = 0, sumY = 0;
            for (int j = 0; j < n; j++) {
                sumX += arr[i][j];
                sumY += arr[j][i];
            }
            sumD1 += arr[i][i];
            sumD2 += arr[i][n - 1 - i];
            max = Math.max(max, Math.max(sumX, sumY));
        }
        max = Math.max(max, Math.max(sumD1, sumD2));
        System.out.println(max);
    }
}
