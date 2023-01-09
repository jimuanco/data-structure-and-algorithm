package Lecture.Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex01 {
    public ArrayList<String> solution(int n, String[] s) {
        ArrayList<String> answer = new ArrayList<>();
        answer.add(s[0]);
        for(int i=0; i<n-1; i++) {
            if(Integer.parseInt(s[i]) < Integer.parseInt(s[i+1])) {
                answer.add(s[i+1]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Ex01 T = new Ex01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for(int i=0; i<n; i++) {
            str[i]=kb.next();
        }
        for(String x : T.solution(n, str)) {
            System.out.print(x + " ");
        }
    }
}
