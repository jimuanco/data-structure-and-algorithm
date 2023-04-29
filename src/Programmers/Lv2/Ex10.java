package Programmers.Lv2;

//2017 팁스타운
//짝지어 제거하기(Lv2)

/*
s	result
baabaa	1
cdcd	0
 */
import java.util.*;

class Ex10
{
    public static void main(String[] args)
    {
        String s = "baabaa";
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i=1; i<s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        if(stack.isEmpty()) {
            answer = 1;
        }

        System.out.println(answer);
    }
}