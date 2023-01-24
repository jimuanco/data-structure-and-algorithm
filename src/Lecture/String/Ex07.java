package Lecture.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//회문 문자열
public class Ex07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String answer="NO";
        String tmp=new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)) answer="YES";
        System.out.println(answer);
    }
}

class Ex07_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        String answer="YES";
        str=str.toUpperCase();
        int len=str.length();
        for(int i=0; i<len/2; i++) {
            if(str.charAt(i)!=str.charAt(len-i-1)) answer="NO";
        }
        System.out.println(answer);
    }
}
