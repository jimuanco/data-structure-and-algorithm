package Lecture.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//교육과정설계
public class Ex07_2 {
    public String solution(String need, String plan) {
        String answer="YES";
        Queue<Character> Q = new LinkedList<>();
        for(char x : need.toCharArray()) Q.offer(x);
        for(char x : plan.toCharArray()) {
            if(Q.contains(x)) {
                if(Q.peek()==x) Q.poll();
                else return "NO";
            }
        }
        if(Q.size()>0) return "NO";
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex07_2 T = new Ex07_2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        System.out.print(T.solution(a, b));
    }
}
