package Review.Lecture2025.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열 압축
// KKHSSSSSSSE
// KSTTTSEEKFKKKDJJGG
// 답이 더 깔끔
public class Ex11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                cnt++;
            } else {
                if (cnt != 1) {
                    sb.append(cnt);
                }
                cnt = 1;
                sb.append(str.charAt(i));
            }
        }
        if (cnt != 1) {
            sb.append(cnt);
        }
        System.out.println(sb);
    }
}
