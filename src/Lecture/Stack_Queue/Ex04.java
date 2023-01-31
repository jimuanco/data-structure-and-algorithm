package Lecture.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//후위식 연산(postfix)
public class Ex04 {
    public int solution(String str) {
        int answer=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                stack.add(Integer.parseInt(String.valueOf(str.charAt(i))));
            } else {
                int tmp = stack.pop();
                if(str.charAt(i)=='+') {
                    answer = stack.pop() + tmp;
                } else if(str.charAt(i)=='-') {
                    answer = stack.pop() - tmp;
                } else if(str.charAt(i)=='*') {
                    answer = stack.pop() * tmp;
                } else {
                    answer = stack.pop() / tmp;
                }
                stack.push(answer);
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Ex04 T = new Ex04();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        System.out.println(T.solution(str));
    }
}
