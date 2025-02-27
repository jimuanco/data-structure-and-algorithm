package Review.Lecture2025.HashMap_TreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 모든 아나그램 찾기
/*
bacaAacba
abc
 */
// 답이 더 깔끔
public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        int n = str1.length();
        int k = str2.length();
        int ans = 0;
        for (int i = 0; i < k; i++) {
            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0) + 1);
        }

        for (int i = 0; i < k - 1; i++) {
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
        }
        for (int i = k - 1; i < n; i++) {
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
            if (map1.equals(map2)) {
                ans++;
            }
            map1.put(str1.charAt(i - k + 1), map1.getOrDefault(str1.charAt(i - k + 1), 0) - 1);
            if (map1.get(str1.charAt(i - k + 1)) == 0) {
                map1.remove(str1.charAt(i - k + 1));
            }

        }
        System.out.println(ans);
    }
}
