package Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//평범한 배낭
//Lecture DP Ex06(최대점수 구하기(냅색 알고리즘, 가방 문제)) 와 같은 유형
//다중 배열 이용해 갯수 1개임에도 for문 끝에서 부터 시작 하지 않고 처음부터 시작해 푸는방법
//다중 배열 때문인지 a1보다 메모리,시간효율 모두 떨어짐 -> 굳이 이렇게 풀 필요 없음
public class Ex12865_a2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[][] dp=new int[n+1][k+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight=Integer.parseInt(st.nextToken());
            int worth=Integer.parseInt(st.nextToken());
            for(int j=1; j<=k; j++) {
                if(j>=weight) {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight]+worth);
                } else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
