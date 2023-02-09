package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//파도반 수열 -> 어느 수 부터 int형을 넘음 long 써야함
public class Ex9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            int n=Integer.parseInt(br.readLine());
//            int[] dp=new int[n+1]; //런타임 에러 (ArrayIndexOutOfBounds)
            long[] dp=new long[101];
            dp[1]=1;
            dp[2]=1;
            dp[3]=1;
            for(int j=4; j<=n; j++) {
                dp[j]=dp[j-3]+dp[j-2];
            }
            sb.append(dp[n]+"\n");
        }
        System.out.println(sb);
    }
}
