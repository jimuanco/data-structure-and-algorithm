package Review.Lecture2025.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 대소문자 변환
public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(Character.toUpperCase(c));
            }
        }
        System.out.println(sb);
    }
}
