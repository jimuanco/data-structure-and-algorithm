package Review.Lecture.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//괄호문자제거
public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        String answer="";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(x==')') {
                while(stack.pop()!='(');
            } else stack.push(x);
        }
        for(char x : stack) {
            answer +=x;
        }
        System.out.println(answer);
    }
}
