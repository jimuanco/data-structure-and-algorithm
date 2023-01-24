package Lecture.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//숫자만 추출
public class Ex09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
//        int answer=0;
        String answer="";
        for(char x : str.toCharArray()) {
//            if(x>=48 && x<=57) answer=answer*10+(x-48);
//            if(Character.isDigit(x)) answer=answer*10+Character.getNumericValue(x);
            if(Character.isDigit(x)) answer+=x;
        }
        System.out.println(Integer.parseInt(answer));
    }
}
