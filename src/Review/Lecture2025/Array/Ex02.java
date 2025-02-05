package Review.Lecture2025.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 보이는 학생
/*
8
130 135 148 140 145 150 150 153
 */
public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE, answer = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }
        System.out.println(answer);
    }
}
