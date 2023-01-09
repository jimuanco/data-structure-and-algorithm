package Lecture.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//채점은 맞다고 뜨는데 잘 못 한듯, 풀이대로 풀어
public class Ex07 {
    public String solution(String str1, String str2) {
        String answer = "YES";
        int s = Integer.MAX_VALUE;
        Queue<Character> Q = new LinkedList<>();
        for(int i=0; i<str2.length(); i++) {
            Q.offer(str2.charAt(i));
        }
        for(int i=0; i<str1.length(); i++) {
            while(Q.contains(str1.charAt(i))) {
                Q.poll();
            }
            if(i+1 < str1.length() && !Q.contains(str1.charAt(i+1))) return "NO"; //if문 조건 순서 중요
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex07 T = new Ex07();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        System.out.print(T.solution(str1, str2));
    }
}
