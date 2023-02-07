package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//계단 오르기
public class Ex2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n+1];
        StringTokenizer st;
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[][] dp=new int[2][n+1];
        dp[0][0]=0;
        dp[1][0]=0;
        dp[0][1]=arr[1];
        for(int i=2; i<=n; i++) {
            dp[0][i]=Math.max(dp[0][i-2],dp[1][i-2])+arr[i];
            dp[1][i]=dp[0][i-1]+arr[i];
        }
        System.out.println(Math.max(dp[0][n],dp[1][n]));
    }
}
