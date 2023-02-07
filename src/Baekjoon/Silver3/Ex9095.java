package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1, 2, 3 더하기
public class Ex9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            int n=Integer.parseInt(br.readLine());
//            int[] dp=new int[n+1]; //런타임 에러 (ArrayIndexOutOfBounds)
            int[] dp=new int[11];
            dp[1]=1;
            dp[2]=2;
            dp[3]=4;
            for(int j=4; j<=n; j++) {
                dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
            }
            sb.append(dp[n]+"\n");
        }
        System.out.println(sb);
    }
}
