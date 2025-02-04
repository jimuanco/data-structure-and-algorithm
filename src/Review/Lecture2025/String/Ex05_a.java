package Review.Lecture2025.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 특정 문자 뒤집기
public class Ex05_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] arr = str.toCharArray();
        int lt = 0, rt = arr.length - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(arr[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(arr[rt])) {
                rt--;
            } else {
                char temp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = temp;
                lt++;
                rt--;
            }
        }
        String answer = String.valueOf(arr);
        System.out.println(answer);
    }
}
