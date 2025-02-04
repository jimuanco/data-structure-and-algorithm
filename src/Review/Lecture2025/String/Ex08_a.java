package Review.Lecture2025.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 유효한 팰린드롬
public class Ex08_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String temp = new StringBuilder(str).reverse().toString();

        String answer = "NO";
        if (str.equals(temp)) {
            answer = "YES";
        }
        System.out.println(answer);

    }
}
