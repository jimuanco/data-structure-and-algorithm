package Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//가장 긴 증가하는 부분 수열
//Lecture DP Ex03과 같은 유형
public class Ex11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] dp=new int[n];
        dp[0]=1;
        int answer=dp[0];
        for(int i=1; i<n; i++) {
            int max=0; //앞에 자기보다 작은 숫자가 없는경우 0+1을 해야함
            for(int j=i-1; j>=0; j--) {
                if(arr[i]>arr[j]) {
                    max=Math.max(dp[j],max);
                }
            }
            dp[i]=max+1;
            answer=Math.max(answer,dp[i]);
        }
        System.out.println(answer);
    }
}
