package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//기타리스트
public class Ex1495_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        int[][] dp=new int[n][m+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        if(s+arr[0]<=m) dp[0][s+arr[0]]=1;
        if(s-arr[0]>=0) dp[0][s-arr[0]]=1;
        for(int i=1; i<n; i++) {
            for(int j=0; j<=m; j++) {
                if(dp[i-1][j]==1 && j+arr[i]<=m) dp[i][j+arr[i]]=1;
                if(dp[i-1][j]==1 && j-arr[i]>=0) dp[i][j-arr[i]]=1;
            }
        }
        int answer=Integer.MIN_VALUE;
        for(int i=m; i>=0; i--) {
            if(dp[n-1][i]==1) {
                answer=Math.max(answer,i);
            }
        }
        if(answer!=Integer.MIN_VALUE) System.out.println(answer);
        else System.out.println(-1);
    }
}
