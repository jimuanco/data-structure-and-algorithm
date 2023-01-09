package Lecture.String;

import java.util.Scanner;

class Ex11 {
    public String solution(String s) {
        String answer = String.valueOf(s.charAt(0));
        int p = 1;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i-1) == s.charAt(i)) {
                p++;
                if(i==s.length() - 1) {
                    answer += p;
                }
            } else {
                if(p!=1) {
                    answer += String.valueOf(p) + s.charAt(i);
                } else {
                    answer += s.charAt(i);
                }
                p = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex11 T = new Ex11();
        Scanner kb = new Scanner((System.in));
        String str  = kb.next();
        System.out.print(T.solution(str));
    }
}
