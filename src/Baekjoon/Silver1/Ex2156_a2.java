package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//포도주 시식
//Top-Down
//Baekjoon Ex2579(계단 오르기)와 같은유형
public class Ex2156_a2 {
    static Integer[] dp;
    static int[] arr;
    static int recur(int n) {
        if(dp[n]==null) { //이거 위해 dp는 Integer형으로
            dp[n]=Math.max(recur(n-1),Math.max(recur(n-2)+arr[n],recur(n-3)+arr[n-1]+arr[n]));
        }
        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        arr=new int[n+1];
        for(int i=1; i<=n; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        dp=new Integer[n+1];
        dp[0]=0;
        dp[1]=arr[1];
        if(n>1) dp[2]=arr[1]+arr[2];
        System.out.println(recur(n));
    }
}
