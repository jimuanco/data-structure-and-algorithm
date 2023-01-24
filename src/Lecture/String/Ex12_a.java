package Lecture.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//암호
public class Ex12_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String str = br.readLine();
        String answer="";
        for(int i=0; i<n; i++) {
            String tmp = str.substring(0,7).replace('#','1').replace('*','0');
            int num=Integer.parseInt(tmp,2); //2진수 -> 10진수
            answer+=(char)num;
            str=str.substring(7);
        }
        System.out.println(answer);
    }
}
