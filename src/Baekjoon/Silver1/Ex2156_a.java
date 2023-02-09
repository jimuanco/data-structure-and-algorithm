package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//포도주 시식
//Bottom-Up
//dp는 이전 잔들을 선택 한 최대 합
//Baekjoon Ex2579(계단 오르기)와 같은유형
public class Ex2156_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n+1];
        int[] dp=new int[n+1];
        for(int i=1; i<=n; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        dp[1]=arr[1];
        /*
         *  N이 1로 주어질 수 있으므로 조건식 달아둠
         *  또한 dp[2]는 어떤 경우에도 첫 번째와 두 번째를 합한 것이 최댓값
         */
        if(n>1) dp[2]=arr[1]+arr[2];
        for(int i=3; i<=n; i++) {
            dp[i]=Math.max(dp[i-1],Math.max(dp[i-2],dp[i-3]+arr[i-1])+arr[i]);
        }
        System.out.println(dp[n]);
    }
}
