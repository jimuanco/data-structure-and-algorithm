package Review.Lecture2025.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자 찾기
public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();
        str = str.toUpperCase();
        char c = br.readLine().charAt(0);
        c = Character.toUpperCase(c);

        int answer = 0;
        for (char x : str.toCharArray()) {
            if (x == c) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
