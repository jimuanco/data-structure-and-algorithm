package Review.Lecture.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//쇠막대기
public class Ex05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer=0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)=='(') stack.push(str.charAt(i));
            else {
                stack.pop();
                if(str.charAt(i-1)=='(') answer+=stack.size();
                else answer++;
            }
        }
        System.out.println(answer);
    }
}
