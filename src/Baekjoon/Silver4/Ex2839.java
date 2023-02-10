package Baekjoon.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//설탕 배달
//Lecture DP Ex05(동전교환)과 비슷한 유형
public class Ex2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] dp=new int[n+1];
        int[] sugar= {3,5};
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0; i<2; i++) {
            for(int j=sugar[i]; j<=n; j++) {
                if(dp[j-sugar[i]]!=Integer.MAX_VALUE) dp[j]=Math.min(dp[j],dp[j-sugar[i]]+1);
            }
        }
        if(dp[n]==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[n]);
    }
}
