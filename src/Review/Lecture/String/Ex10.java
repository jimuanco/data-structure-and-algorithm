package Review.Lecture.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//가장 짧은 문자거리
public class Ex10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        char t = st.nextToken().charAt(0);
        int[] answer=new int[s.length()];
        int p=1000;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)==t) {
                p=0;
            } else {
                p++;
            }
            answer[i]=p;
        }
        p=1000;
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i)==t) p=0;
            else {
                p++;
                answer[i]=Math.min(answer[i],p);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int x : answer) {
            sb.append(x+" ");
        }
        System.out.println(sb);
    }
}
