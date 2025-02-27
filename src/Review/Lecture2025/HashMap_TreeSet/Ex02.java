package Review.Lecture2025.HashMap_TreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 아나그램(해쉬)
/*
AbaAeCe
baeeACA
 */
/*
abaCC
Caaab
 */
// 길이가 같다는 전제가 있다.
// 답이 더 깔끔
public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        String ans = "YES";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : str2.toCharArray()) {
            if (!map.containsKey(c)) {
              ans = "NO";
              break;
            } else {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }
        if (map.isEmpty()) {
            ans = "YES";
        } else {
            ans = "NO";
        }
        System.out.println(ans);
    }
}
