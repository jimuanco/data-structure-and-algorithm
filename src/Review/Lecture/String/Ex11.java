package Review.Lecture.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문자열 압축
public class Ex11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String answer="";
        str=str+" ";
        int cnt=1;
        for(int i=0; i<str.length()-1; i++) {
            if(str.charAt(i)==str.charAt(i+1)) cnt++; //이거때문에 위에 str=str+" ";
            else {
                answer+=str.charAt(i);
                if(cnt>1) answer+=cnt; //String.valueOf(cnt) 안해도 되네?
                cnt=1;
            }
        }
        System.out.println(answer);
    }
}
