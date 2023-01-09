package Lecture.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex02_a {
    public String solution(String str) {
        String answer="";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(x==')') {
                while(stack.pop()!='(');
            } else stack.push(x);
        }
        for(int i=0; i<stack.size(); i++) answer+=stack.get(i);
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex02_a T = new Ex02_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        System.out.print(T.solution(str));
    }
}
