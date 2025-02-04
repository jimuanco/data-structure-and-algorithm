package Review.Lecture2025.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 중복문자제거
public class Ex06_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
