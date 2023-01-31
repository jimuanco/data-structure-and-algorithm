package Lecture.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//괄호문자제거
public class Ex02 {
    public String solution(String str) {
        String answer="";
        Stack<Character> stack = new Stack<Character>();
        for(char x : str.toCharArray()) {
            stack.push(x);
            if(stack.lastElement()==')') {
                while(stack.lastElement()!='(') {
                    stack.pop();
                }
                if(stack.lastElement()=='(') stack.pop();
            }
        }
        //char x : stack 해도 돼
        for(Object x : stack.toArray()) {
            answer += x;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex02 T = new Ex02();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        System.out.print(T.solution(str));
    }
}
