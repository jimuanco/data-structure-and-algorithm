package Lecture.String;

import java.util.Scanner;

//문자열 압축
public class Ex11_a {
    public String solution(String s) {
        String answer = "";
        s = s + " ";
        int cnt = 1;
        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i)==s.charAt(i+1)) cnt++; //이거때문에 위에 str=str+" ";
            else {
                answer += s.charAt(i);
                if(cnt>1) answer += String.valueOf(cnt); //걍 cnt 해도 되네?
                cnt = 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Ex11_a T = new Ex11_a();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));

    }
}
