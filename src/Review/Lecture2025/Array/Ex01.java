package Review.Lecture2025.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 큰 수 출력하기
public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        sb.append(" ");
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                sb.append(arr[i]);
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
