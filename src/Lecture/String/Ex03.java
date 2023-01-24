package Lecture.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문장 속 단어
public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String answer="";
        int m=Integer.MIN_VALUE;
        String[] s = str.split(" ");
        for(String x : s) {
            int len=x.length();
            if(len>m) {
                m=len;
                answer=x;
            }
        }
        System.out.print(answer);
    }
}
