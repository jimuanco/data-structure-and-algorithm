package Baekjoon.Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//부녀회장이 될테야
public class Ex2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            int k=Integer.parseInt(br.readLine());
            int n=Integer.parseInt(br.readLine());
            int[][] dp=new int[k+1][n+1];
            for(int j=1; j<=n; j++) {
                dp[0][j]=j;
            }
            for(int l=1; l<=k; l++) {
                for(int j=1; j<=n; j++) {
                    for(int m=j; m>=1; m--) {
                        dp[l][j]+=dp[l-1][m];
                    }
                }
            }
            sb.append(dp[k][n]+"\n");
        }
        System.out.println(sb);
    }
}
