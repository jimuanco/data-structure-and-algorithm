package Lecture.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//대소문자 변환
public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        String answer="";
        for(char x : str.toCharArray()) {
            if(x>=97 && x<=122) answer+=(char)(x-32); //영문 소문자 ASCII code 97~122, 대문자 65~90
            else answer+=(char)(x+32);
        }
        System.out.print(answer);
    }
}

class Ex02_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String answer="";
        for(char x : str.toCharArray()) {
            if(Character.isLowerCase(x)) answer+=Character.toUpperCase(x);
            else answer+=Character.toLowerCase(x);
        }
        System.out.println(answer);
    }
}
