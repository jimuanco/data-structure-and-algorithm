package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2×n 타일링
//피보나치수열로 풀면 돼
public class Ex11726_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
//        int[] dp=new int[n+1]; //런타임 에러 (ArrayIndexOutOfBounds) 뜸 (왜지?)
        int[] dp=new int[1001];
        dp[1]=1;
        dp[2]=2;
        for(int i=3; i<=n; i++) {
            dp[i]=(dp[i-2]+dp[i-1])%10007;
        }
        System.out.println(dp[n]);
    }
}
