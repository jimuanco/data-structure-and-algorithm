package Review.Lecture2025.TwoPointers_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 두 배열 합치기
/*
3
1 3 5
5
2 3 6 7 9
 */
public class Ex01_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> answer = new ArrayList<>();
        int p0 = 0, p1 = 0;
        while (p0 < n && p1 < m) {
            if (arr1[p0] < arr2[p1]) {
                answer.add(arr1[p0++]);
            } else {
                answer.add(arr2[p1++]);
            }
        }
        while (p0 < n) {
            answer.add(arr1[p0++]);
        }
        while (p1 < m) {
            answer.add(arr2[p1++]);
        }
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
    }
}
