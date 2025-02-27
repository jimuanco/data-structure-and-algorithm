package Review.Lecture2025.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 후위식 연산(postfix)
// 352+*9-
public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int tmp1 = stack.pop();
                int tmp2 = stack.pop();
                if (c == '+') {
                    stack.push(tmp2 + tmp1);
                } else if (c == '-') {
                    stack.push(tmp2 - tmp1);
                } else if (c == '*') {
                    stack.push(tmp2 * tmp1);
                } else {
                    stack.push(tmp2 / tmp1);
                }
            }
        }
        System.out.println(stack.pop());
    }
}
