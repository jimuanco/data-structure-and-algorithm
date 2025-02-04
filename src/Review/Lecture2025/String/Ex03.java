package Review.Lecture2025.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문장 속 단어
public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int max = Integer.MIN_VALUE;
        String answer = "";
        String[] arr = str.split(" ");
        for (String s : arr) {
            if (s.length() > max) {
                max = s.length();
                answer = s;
            }
        }
        System.out.println(answer);
    }
}
