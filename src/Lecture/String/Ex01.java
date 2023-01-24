package Lecture.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문자 찾기
public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char c = br.readLine().charAt(0);
        str=str.toUpperCase();
        c=Character.toUpperCase(c);
//        System.out.println(str + " " + c);
        int answer=0;
//        for(int i=0; i<str.length(); i++) {
//            if(str.charAt(i)==c) answer++;
//        }
        for (char x : str.toCharArray()) {
            if(x==c) answer++;
        }
        System.out.print(answer);
    }
}
