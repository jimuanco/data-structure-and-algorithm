package Lecture.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//유효한 팰린드롬
public class Ex08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        String answer="NO";
        str=str.toUpperCase().replaceAll("[^A-Z]",""); //^는 부정, 따라서 알파벳 대문자 아닌것들 replaceAll
        String tmp=new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) answer="YES";
        System.out.println(answer);
    }
}
