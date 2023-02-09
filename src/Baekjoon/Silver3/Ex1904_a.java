package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//01타일
//피보나치 수열로 품
public class Ex1904_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[] dp=new long[1000001];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        int mod=15746;
        for(int i=3; i<=n; i++) {
            dp[i]=(dp[i-1]+dp[i-2])%mod; //매번 해줘야 함(N이 46일 때 int형 범위를 벗어나고, N이 92일 때 long타입의 범위를 벗어남)
        }
        System.out.println(dp[n]); //여긴 %mod 안해줘도 되네
    }
}
