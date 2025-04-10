package Review.Lecture2025.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 숫자만 추출
public class Ex09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        System.out.println(Integer.parseInt(sb.toString()));
    }
}
