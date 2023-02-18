package Baekjoon.Platinum4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//평범한 배낭2
public class Ex12920_timeLimitExceeded {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] dp = new int[m+1];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight= Integer.parseInt(st.nextToken());
            int worth= Integer.parseInt(st.nextToken());
            int num= Integer.parseInt(st.nextToken());
            for(int j=0; j<num; j++) {
                for(int k=m; k>=weight; k--) {
                    dp[k]=Math.max(dp[k],dp[k-weight]+worth);
                }
            }
        }
        System.out.println(dp[m]);
    }
}

/*
3 9
8 5 1
1 4 2
9 4 1
 */