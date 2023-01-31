package Lecture.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//교육과정설계
public class Ex07_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String need=br.readLine();
        String plan=br.readLine();
        String answer="YES";
        Queue<Character> Q = new LinkedList<>();
        for(char x : need.toCharArray()) Q.offer(x);
        for(char x : plan.toCharArray()) {
            if(Q.contains(x)) {
                if(Q.poll()!=x) { //여기서 poll됨
                    answer="NO";
                    break;
                }
            }
        }
        if(!Q.isEmpty()) answer="NO";
        System.out.println(answer);
    }
}
