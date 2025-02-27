package Review.Lecture2025.HashMap_TreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 매출액의 종류
/*
7 4
20 12 20 10 23 17 10
 */
// 답 봐
public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        ans.add(map.size());
        for (int i = k; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            map.put(arr[i - k], map.getOrDefault(arr[i - k], 0) - 1);
            if (map.get(arr[i - k]) == 0) {
                map.remove(arr[i - k]);
            }
            ans.add(map.size());
        }
        for (Integer i : ans) {
            System.out.print(i + " ");
        }
    }
}
