package Review.Lecture2025.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 암호
/*
4
#****###**#####**#####**##**
 */
// 답이 더 깔끔
public class Ex12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                sb.append(1);
            }
            if (str.charAt(i) == '*') {
                sb.append(0);
            }
            if ((i + 1) % 7 == 0) {
                int num = Integer.parseInt(sb.toString(), 2);
                answer.append((char)num);
                sb = new StringBuilder();
            }

        }
        System.out.println(answer);
    }
}
