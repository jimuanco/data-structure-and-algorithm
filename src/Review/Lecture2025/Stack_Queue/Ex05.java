package Review.Lecture2025.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 쇠막대기
// ()(((()())(())()))(())
// (((()(()()))(())()))(()())
// 답이 더 깔끔
public class Ex05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int ans = 0, cnt = 0;
        for (char x : str.toCharArray()) {
            if (x == '(') {
                cnt++;
                stack.push(x);
            } else if (x == ')' && stack.peek() == '(') {
                cnt--;
                ans += cnt;
                stack.push(x);
            } else if (x == ')' && stack.peek() == ')') {
                ans++;
                cnt--;
            }
        }
        System.out.println(ans);
    }
}
