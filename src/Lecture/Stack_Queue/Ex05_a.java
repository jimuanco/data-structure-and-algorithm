package Lecture.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//쇠막대기
public class Ex05_a {
    public int solution(String str) {
        int answer=0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)=='(') stack.push('(');
            else {
                stack.pop();
                if(str.charAt(i-1)=='(') answer += stack.size();
                else answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex05_a T = new Ex05_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.print(T.solution(str));
    }
}
