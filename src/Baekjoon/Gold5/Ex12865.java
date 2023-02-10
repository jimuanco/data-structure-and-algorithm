package Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//평범한 배낭
//Lecture DP Ex06(최대점수 구하기(냅색 알고리즘, 가방 문제)) 와 같은 유형
public class Ex12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] dp=new int[k+1];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight=Integer.parseInt(st.nextToken());
            int worth=Integer.parseInt(st.nextToken());
            for(int j=k; j>=weight; j--) {
                dp[j]=Math.max(dp[j],dp[j-weight]+worth);
            }
        }
        System.out.println(dp[k]);
    }
}
