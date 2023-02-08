package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//포도주 시식
//Ex2579(계단 오르기) 처럼 풀었더니 틀림..
//반례
//10
//0
//0
//10
//0
//5
//10
//0
//0
//1
//10
public class Ex2156_wrong2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n+1];
        int[][] dp=new int[2][n+1];
        for(int i=1; i<=n; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        dp[0][1]=arr[1];
        for(int i=2; i<=n; i++) {
            dp[0][i]=Math.max(dp[0][i-2],dp[1][i-2])+arr[i];
            dp[1][i]=dp[0][i-1]+arr[i];
        }
        int answer=Integer.MIN_VALUE;
        for(int i=0; i<=n; i++) {
            int max=Math.max(dp[0][i],dp[1][i]);
            answer=Math.max(answer,max);
        }
        System.out.println(answer);
    }
}
