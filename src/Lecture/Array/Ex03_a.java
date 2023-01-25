package Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//가위 바위 보
public class Ex03_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            b[i]=Integer.parseInt(st.nextToken());
        }
        String answer=""; //바로 StringBuilder에 append해도 되겠네
        for(int i=0; i<n; i++) {
            if(a[i]==b[i]) answer+="D";
            else if(a[i]==1 && b[i]==3) answer+="A"; //A부터 다 따지고 else B로 처리
            else if(a[i]==2 && b[i]==1) answer+="A";
            else if(a[i]==3 && b[i]==2) answer+="A";
            else answer+="B";
        }
        StringBuilder sb = new StringBuilder();
        for(char x : answer.toCharArray()) {
            sb.append(x+"\n");
        }
        System.out.println(sb);
    }
}
