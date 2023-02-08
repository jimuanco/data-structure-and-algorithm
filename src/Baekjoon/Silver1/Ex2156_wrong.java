package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//포도주 시식
//틀린 이유: 꼭 한칸씩만 띄울 필요 없음
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
public class Ex2156_wrong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        int[][] dp=new int[3][n];
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        dp[0][0]=arr[0];
        dp[2][0]=arr[0];
        for(int i=1; i<n; i++) {
            if((i+1)%3!=0) dp[0][i]=dp[0][i-1]+arr[i];
            else dp[0][i]=dp[0][i-1];
            if(i%3!=0) dp[1][i]=dp[1][i-1]+arr[i];
            else dp[1][i]=dp[1][i-1];
            if((i+2)%3!=0) dp[2][i]=dp[2][i-1]+arr[i];
            else dp[2][i]=dp[2][i-1];
        }
        System.out.println(Math.max((Math.max(dp[0][n-1],dp[1][n-1])),dp[2][n-1]));
    }
}
