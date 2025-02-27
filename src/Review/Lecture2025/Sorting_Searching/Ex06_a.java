package Review.Lecture2025.Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 장난꾸러기
/*
9
120 125 152 130 135 135 143 127 160
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

        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            if (arr[i] != tmp[i]) {
                ans.add(i + 1);
            }
        }
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
