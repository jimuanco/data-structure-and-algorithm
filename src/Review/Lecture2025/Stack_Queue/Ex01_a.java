package Review.Lecture2025.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 올바른 괄호
/*
(()(()))(()
 */
public class Ex01_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String ans = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) {
                    ans = "NO";
                    break;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            ans = "NO";
        }
        System.out.println(ans);
    }
}
