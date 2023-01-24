package Lecture.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//중복문자제거
public class Ex06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String answer="";
        for(int i=0; i<str.length(); i++) {
//            System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
            if(str.indexOf(str.charAt(i))==i) answer+=str.charAt(i); //indexOf -> 제일 처음 발견된 index 번호 리턴
        }
        System.out.println(answer);
    }
}
