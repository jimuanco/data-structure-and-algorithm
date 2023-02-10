package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//이친수
//피보나치 수열
public class Ex2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
//        long[] dp=new long[n+1];
        long[] dp=new long[91]; //조심!
        dp[1]=1;
        dp[2]=1;
        for(int i=3; i<=n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
