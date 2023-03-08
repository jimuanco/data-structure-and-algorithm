package Programmers.HighScoreKit.Stack_Queue;

import java.util.*;

//올바른 괄호(Lv2)
/*
s	answer
"()()"	true
"(())()"	true
")()("	false
"(()("	false
 */
//Lecture.Stack_Queue.Ex01(올바른 괄호)과 똑같은 문제
class Ex03 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(char x : s.toCharArray()) {
            if(x=='(') {
                stack.push(x);
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return answer;
    }
}