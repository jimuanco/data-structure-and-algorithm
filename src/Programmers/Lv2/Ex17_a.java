package Programmers.Lv2;

//2020 KAKAO BLIND RECRUITMENT
//괄호 변환(Lv2)

/*
p	result
"(()())()"	"(()())()"
")("	"()"
"()))((()"	"()(())()"
 */

import java.util.*;

class Ex17_a {
    public static void main(String[] args) {
        String p = "()))((()";
        String answer = DFS(p);
        System.out.println(answer);
    }

    static String DFS(String w) {
        if(w.length() == 0) {
            return "";
        }

        String u = "";
        String v = "";
        int lcnt = 0;
        int rcnt = 0;

        for(int i=0; i<w.length(); i++) {
            if(w.charAt(i) == '(') {
                lcnt++;
            } else {
                rcnt++;
            }
            u += w.charAt(i);
            if(lcnt == rcnt) {
                v += w.substring(i+1);
                break;
            }
        }

        if(isCorrect(u)) {
            return u += DFS(v);
        } else {
            String tmp = "(";
            tmp += DFS(v);
            tmp += ")";
            u = u.substring(1,u.length()-1);
            for(char x : u.toCharArray()) {
                if(x == '(') {
                    tmp += ")";
                } else {
                    tmp += "(";
                }
            }
            return tmp;
        }
    }

    static boolean isCorrect(String u) {
        Stack<Character> stack = new Stack<>();
        for(char x : u.toCharArray()) {
            if(x == '(') stack.push(x);
            else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
