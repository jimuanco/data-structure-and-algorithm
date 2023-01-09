package Lecture.String;

import java.util.Scanner;

public class Ex12 {
    public String solution(String s, int n) {
        String tmp ="";
        String tmp2 ="";
        String answer ="";
        for(int j=0; j<s.length(); j++) {
            tmp += s.charAt(j);
            if((j+1) % 7 == 0) {
                tmp2 = tmp.replace("#","1").replace("*","0");
                int x = Integer.parseInt(tmp2,2);
                char c = (char)x;
                tmp ="";
                answer += c;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Ex12 T = new Ex12();
        Scanner kb = new Scanner(System.in);
        //next 순서 주의!
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(T.solution(str, n));
    }
}

//n이 굳이 없어도 됨
