package Review.Lecture2025.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 회문 문자열
public class Ex07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        int lt = 0, rt = str.length() - 1;
        String answer = "YES";
        while (lt < rt) {
            if (str.charAt(lt) != str.charAt(rt)) {
                answer = "NO";
                break;
            }
            lt++;
            rt--;
        }
        System.out.println(answer);
    }
}
