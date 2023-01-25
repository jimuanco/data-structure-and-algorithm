package Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//피보나치 수열
public class Ex04_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int a=1,b=1,c;
        StringBuilder sb = new StringBuilder();
        sb.append(a+" "+b+" ");
        for(int i=2; i<n; i++) {
            c=a+b;
            sb.append(c+" ");
            a=b;
            b=c;
        }
        System.out.println(sb);
    }
}

class Ex04_a2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] answer=new int[n];
        answer[0]=1;
        answer[1]=1;
        for(int i=2; i<n; i++) {
            answer[i]=answer[i-2]+answer[i-1];
        }
        StringBuilder sb = new StringBuilder();
        for(int x : answer) {
            sb.append(x+" ");
        }
        System.out.println(sb);
    }
}
