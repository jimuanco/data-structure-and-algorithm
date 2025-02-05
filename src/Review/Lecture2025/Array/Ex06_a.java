package Review.Lecture2025.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 뒤집은 소수
/*
9
32 55 62 20 250 370 200 30 100
 */
public class Ex06_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if (res == 1) {
                continue;
            }
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(res); j++) {
                if (res % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer.add(res);
            }
        }
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
    }
}
