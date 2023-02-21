package Baekjoon.Platinum5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//큰 수 만들기
//Programmers.HighScoreKit.Sort.Ex02(가장 큰 수)와 똑같은 문제
public class Ex16496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] str = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            str[i]=st.nextToken();
        }
        Arrays.sort(str, (a,b)->(b+a).compareTo(a+b));
        if(str[0].equals("0")) { //"0000" 이라면 0출력
            System.out.println(0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(String s : str) {
            sb.append(s);
        }
        System.out.println(sb);
    }
}
